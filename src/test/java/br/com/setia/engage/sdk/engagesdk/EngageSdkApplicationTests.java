package br.com.setia.engage.sdk.engagesdk;


import br.com.setia.engage.sdk.engagesdk.api.operation.Network;
import br.com.setia.engage.sdk.engagesdk.api.operation.TriggerOperation;
import br.com.setia.engage.sdk.engagesdk.model.engine.Trigger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

class EngageSdkApplicationTests {

    private Network network = Network.setProduction("customer-ID", "customer-KEY");

    @Test
    void testTrigger_GetItems() throws IOException {
        TriggerOperation triggerOperation = new TriggerOperation(network);
        List<Trigger> items = triggerOperation.getItems();
        Assertions.assertTrue(!CollectionUtils.isEmpty(items));
    }
}
