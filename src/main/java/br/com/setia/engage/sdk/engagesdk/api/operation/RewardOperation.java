package br.com.setia.engage.sdk.engagesdk.api.operation;

import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.Network;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.NetworkOperation;
import br.com.setia.engage.sdk.engagesdk.model.reward.Reward;
import okhttp3.Request;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RewardOperation extends NetworkOperation {

    public RewardOperation(Network network) {
        super(network);
    }

    public List<Reward> getItems() throws NetworkOperationException {
        Request request = getBaseRequestBuilder(ENDPOINT_REWARD).build();
        try {
            return invokeGetRequest(request, Reward.class, HttpStatus.OK.value());

        } catch (Exception e) {
            throw new NetworkOperationException(e.getMessage(), e);
        }
    }
}
