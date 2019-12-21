package br.com.setia.engage.sdk.engagesdk.api.operation;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.Base64Utils;

import java.io.IOException;

public class NetworkCredentialsInterceptor implements Interceptor {

    private Network network;

    public NetworkCredentialsInterceptor(Network network) {
        this.network = network;
    }

    private String setAuthorizationHeaderData() {
        return new String(Base64Utils.encode((network.getApiCustomerId() + ":" + network.getApiCustomerKey()).getBytes()));
    }

    @NotNull
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request currentRequest = chain.request();
        Request requestWithHeaders = currentRequest.newBuilder()
                .addHeader("Authorization", setAuthorizationHeaderData())
                .build();
        return chain.proceed(requestWithHeaders);
    }
}
