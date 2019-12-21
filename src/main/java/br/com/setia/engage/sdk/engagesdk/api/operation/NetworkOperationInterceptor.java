package br.com.setia.engage.sdk.engagesdk.api.operation;

import br.com.setia.engage.sdk.engagesdk.constants.EngageSdkConstants;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class NetworkOperationInterceptor implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request currentRequest = chain.request();
        Request requestWithHeaders = currentRequest
                .newBuilder()
                .addHeader("X-Engage-Client-Name", EngageSdkConstants.APP_NAME)
                .addHeader("X-Engage-Client-Version", EngageSdkConstants.APP_VERSION).build();
        return chain.proceed(requestWithHeaders);
    }
}
