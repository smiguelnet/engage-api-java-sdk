package br.com.setia.engage.sdk.engagesdk.api.operation;

import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.Network;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.NetworkOperation;
import br.com.setia.engage.sdk.engagesdk.model.engine.Settings;
import okhttp3.Request;
import org.springframework.http.HttpStatus;

public class PlatformOperation extends NetworkOperation {

    public PlatformOperation(Network network) {
        super(network);
    }

    public String getVersion() throws NetworkOperationException {
        Request request = getBaseRequestBuilder(ENDPOINT_VERSION).build();
        return invokeGetRequest(request, String.class, false, HttpStatus.OK.value());
    }

    public Settings getSettings() throws NetworkOperationException {
        Request request = getBaseRequestBuilder(ENDPOINT_SETTINGS).build();
        return invokeGetRequest(request, Settings.class, true, HttpStatus.OK.value());
    }
}
