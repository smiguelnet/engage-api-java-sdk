package br.com.setia.engage.sdk.engagesdk.api.operation;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.concurrent.TimeUnit;

public abstract class NetworkOperation {
    private Network network;
    private OkHttpClient httpClient;
    private ObjectMapper mapper;

    public NetworkOperation(Network network) {
        this.network = network;
        this.mapper = new ObjectMapper();

        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(new NetworkOperationInterceptor())
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
}
