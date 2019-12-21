package br.com.setia.engage.sdk.engagesdk.api.operation;

import br.com.setia.engage.sdk.engagesdk.model.engine.Trigger;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;

public class TriggerOperation extends NetworkOperation {

    public static final String ENDPOINT = "/trigger";

    public TriggerOperation(Network network) {
        super(network);
    }

    public List<Trigger> getItems() throws IOException {
        Request request = getBaseRequestBuilder(ENDPOINT).build();
        Response response = getHttpClient().newCall(request).execute();

        if (response.code() == HttpStatus.OK.value()) {
            String responseContent = response.body().string();

            CollectionType triggerListType = getMapper().getTypeFactory().constructCollectionType(List.class, Trigger.class);
            return getMapper().readValue(responseContent, triggerListType);
        }
        // TODO: 21/12/2019 ...
        return null;
    }

    /*
    public TriggerResponseMessage invokeTrigger(TriggerRequestMessage requestMessage) {
        Request request = getBaseRequestBuilder(ENDPOINT).build();

        getHttpClient().newCall()
    }
    */

}
