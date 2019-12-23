package br.com.setia.engage.sdk.engagesdk.api.operation;

import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import br.com.setia.engage.sdk.engagesdk.api.message.person.PersonResponseMessage;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.Network;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.NetworkOperation;
import okhttp3.Request;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public class PersonOperation extends NetworkOperation {

    public PersonOperation(Network network) {
        super(network);
    }

    public PersonResponseMessage getProfile(String userName) throws NetworkOperationException {
        if (StringUtils.isEmpty(userName)) {
            throw new IllegalArgumentException("Username must be valid to run this request");
        }
        final String urlRequest = ENDPOINT_PERSON + "/" + userName;
        Request request = getBaseRequestBuilder(urlRequest).build();

        return invokeGetRequest(request, PersonResponseMessage.class, true, HttpStatus.OK.value());
    }
}
