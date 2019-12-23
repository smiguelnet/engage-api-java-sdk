package br.com.setia.engage.sdk.engagesdk.api.operation.base;

import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class NetworkOperation {
    private Network network;
    private OkHttpClient httpClient;
    private ObjectMapper mapper;

    //regions ENDPOINTS
    public static final String ENDPOINT_TRIGGER = "/trigger";
    public static final String ENDPOINT_REWARD = "/reward";
    public static final String ENDPOINT_PERSON = "/person";
    public static final String ENDPOINT_VERSION = "/version";
    public static final String ENDPOINT_SETTINGS = "/settings";
    public static final String ENDPOINT_REPORT = "/report";
    //endregion

    public NetworkOperation(Network network) {
        this.network = network;
        this.mapper = new ObjectMapper();

        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(new NetworkHeaderInterceptor())
                .addInterceptor(new NetworkCredentialsInterceptor(network))
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    protected Network getNetwork() {
        return network;
    }

    protected OkHttpClient getHttpClient() {
        return httpClient;
    }

    protected ObjectMapper getMapper() {
        return mapper;
    }

    protected Request.Builder getBaseRequestBuilder(String urlPath) {
        return new Request.Builder().url(getNetwork().getUrl().concat(urlPath));
    }

    protected NetworkOperationException getNetworkOperationExceptionUsingCode(int code, int... acceptedCodes) {
        return new NetworkOperationException(String.format("Invalid return [%d] code for Engage API request. Expected: " + acceptedCodes, code));
    }

    protected <T> T invokePostRequest(Request request, Class<T> modelType, int... acceptedCodes) throws NetworkOperationException {
        try {
            Response response = getHttpClient().newCall(request).execute();
            if (checkAcceptedCodes(response.code(), acceptedCodes)) {
                String responseContent = response.body().string();
                return getMapper().readValue(responseContent, modelType);
            }
            throw getNetworkOperationExceptionUsingCode(response.code(), acceptedCodes);

        } catch (IOException e) {
            throw new NetworkOperationException(e.getMessage(), e);
        }
    }

    protected <T> T invokeGetRequest(Request request,
                                     Class<T> modelType,
                                     boolean parseJson,
                                     int... acceptedCodes) throws NetworkOperationException {
        try {
            Response response = getHttpClient().newCall(request).execute();

            if (checkAcceptedCodes(response.code(), acceptedCodes)) {
                String responseContent = response.body().string();

                if (parseJson) {
                    return getMapper().readValue(responseContent, modelType);
                }
                return (T) responseContent;
            }
            throw getNetworkOperationExceptionUsingCode(response.code(), acceptedCodes);

        } catch (IOException e) {
            throw new NetworkOperationException(e.getMessage(), e);
        }
    }

    protected <T> List<T> invokeGetRequest(Request request,
                                           Class<T> modelType,
                                           int... acceptedCodes) throws NetworkOperationException {
        try {
            Response response = getHttpClient().newCall(request).execute();

            if (checkAcceptedCodes(response.code(), acceptedCodes)) {
                String responseContent = response.body().string();
                CollectionType triggerListType = getMapper().getTypeFactory().constructCollectionType(List.class, modelType);

                return getMapper().readValue(responseContent, triggerListType);
            }
            throw getNetworkOperationExceptionUsingCode(response.code(), acceptedCodes);

        } catch (IOException e) {
            throw new NetworkOperationException(e.getMessage(), e);
        }
    }

    private boolean checkAcceptedCodes(int returnedCode, int... acceptedCodes) {
        if (acceptedCodes == null) {
            return true;
        }
        return Arrays.stream(acceptedCodes).anyMatch(item -> item == returnedCode);
    }
}
