package br.com.setia.engage.sdk.engagesdk.api.operation;

import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import br.com.setia.engage.sdk.engagesdk.api.message.trigger.TriggerRequestMessage;
import br.com.setia.engage.sdk.engagesdk.api.message.trigger.TriggerResponseMessage;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.Network;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.NetworkOperation;
import br.com.setia.engage.sdk.engagesdk.model.engine.Trigger;
import okhttp3.Request;
import org.springframework.http.HttpStatus;

import java.util.List;

public class TriggerOperation extends NetworkOperation {


    public TriggerOperation(Network network) {
        super(network);
    }

    public List<Trigger> getItems() throws NetworkOperationException {
        Request request = getBaseRequestBuilder(ENDPOINT_TRIGGER).build();
        try {
            return invokeGetRequest(request, Trigger.class, HttpStatus.OK.value());

        } catch (Exception e) {
            throw new NetworkOperationException(e.getMessage(), e);
        }
    }

    public TriggerResponseMessage invokeTrigger(TriggerRequestMessage requestMessage) {
        //Request request = getBaseRequestBuilder(ENDPOINT_TRIGGER).build();
        return null;

    }
}
