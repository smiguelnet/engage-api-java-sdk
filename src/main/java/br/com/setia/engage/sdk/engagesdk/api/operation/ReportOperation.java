package br.com.setia.engage.sdk.engagesdk.api.operation;

import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.Network;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.NetworkOperation;
import br.com.setia.engage.sdk.engagesdk.model.report.PersonPoints;
import okhttp3.Request;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ReportOperation extends NetworkOperation {

    public static final String URL_PATH_LEADERBOARD = "/leaderboard";

    public ReportOperation(Network network) {
        super(network);
    }

    public List<PersonPoints> getLeaderboard() throws NetworkOperationException {
        Request request = getBaseRequestBuilder(ENDPOINT_REPORT.concat(URL_PATH_LEADERBOARD)).build();
        return invokeGetRequest(request, PersonPoints.class, HttpStatus.OK.value());
    }
}
