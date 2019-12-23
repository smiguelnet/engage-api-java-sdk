package br.com.setia.engage.sdk.engagesdk.api.operation;

import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import br.com.setia.engage.sdk.engagesdk.api.message.trigger.TriggerRequestMessage;
import br.com.setia.engage.sdk.engagesdk.api.message.trigger.TriggerResponseMessage;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.Network;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.NetworkOperation;
import br.com.setia.engage.sdk.engagesdk.model.engine.Trigger;
import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.http.HttpStatus;

import java.util.List;

public class TriggerOperation extends NetworkOperation {


    public TriggerOperation(Network network) {
        super(network);
    }

    public List<Trigger> getItems() throws NetworkOperationException {
        Request request = getBaseRequestBuilder(ENDPOINT_TRIGGER).build();
        return invokeGetRequest(request, Trigger.class, HttpStatus.OK.value());
    }

    public TriggerResponseMessage invoke(TriggerRequestMessage requestMessage) throws NetworkOperationException {
        String jsonContentToPost = null;
        try {
            jsonContentToPost = getMapper().writeValueAsString(requestMessage);

        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Invalid request message format", e);
        }

        RequestBody requestBody = RequestBody.create(jsonContentToPost, MediaType.parse(org.springframework.http.MediaType.APPLICATION_JSON_VALUE));
        Request request = getBaseRequestBuilder(ENDPOINT_TRIGGER).post(requestBody).build();

        return invokePostRequest(request, TriggerResponseMessage.class, HttpStatus.CREATED.value(), HttpStatus.OK.value());
    }
}
