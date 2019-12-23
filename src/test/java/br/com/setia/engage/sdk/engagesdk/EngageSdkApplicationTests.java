package br.com.setia.engage.sdk.engagesdk;


import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import br.com.setia.engage.sdk.engagesdk.api.operation.PlatformOperation;
import br.com.setia.engage.sdk.engagesdk.api.operation.RewardOperation;
import br.com.setia.engage.sdk.engagesdk.api.operation.TriggerOperation;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.Network;
import br.com.setia.engage.sdk.engagesdk.model.engine.Settings;
import br.com.setia.engage.sdk.engagesdk.model.engine.Trigger;
import br.com.setia.engage.sdk.engagesdk.model.reward.Reward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.List;

class EngageSdkApplicationTests {

    private Network network = Network.setDevelopment("customer-ID", "customer-KEY");

    //region Trigger
    @Test
    void testTrigger_GetItems() throws NetworkOperationException {
        TriggerOperation triggerOperation = new TriggerOperation(network);
        List<Trigger> items = triggerOperation.getItems();
        Assertions.assertTrue(!CollectionUtils.isEmpty(items));
    }
    //endregion


    //region Reward
    @Test
    void testReward_GetItem() throws NetworkOperationException {
        RewardOperation rewardOperation = new RewardOperation(network);
        List<Reward> items = rewardOperation.getItems();
        Assertions.assertTrue(!CollectionUtils.isEmpty(items));
    }
    //endregion


    //region Platform
    @Test
    void testPlatform_GetVersion() throws NetworkOperationException {
        PlatformOperation platformOperation = new PlatformOperation(network);
        String version = platformOperation.getVersion();
        Assertions.assertNotNull(version);
    }

    @Test
    void testPlatform_GetSettings() throws NetworkOperationException {
        PlatformOperation platformOperation = new PlatformOperation(network);
        Settings settings = platformOperation.getSettings();
        Assertions.assertNotNull(settings);
    }
    //endregion
}
