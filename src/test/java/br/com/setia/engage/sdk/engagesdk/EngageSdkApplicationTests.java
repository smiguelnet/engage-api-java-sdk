package br.com.setia.engage.sdk.engagesdk;


import br.com.setia.engage.sdk.engagesdk.api.exception.NetworkOperationException;
import br.com.setia.engage.sdk.engagesdk.api.message.person.PersonResponseMessage;
import br.com.setia.engage.sdk.engagesdk.api.message.trigger.TriggerRequestMessage;
import br.com.setia.engage.sdk.engagesdk.api.message.trigger.TriggerResponseMessage;
import br.com.setia.engage.sdk.engagesdk.api.operation.PersonOperation;
import br.com.setia.engage.sdk.engagesdk.api.operation.PlatformOperation;
import br.com.setia.engage.sdk.engagesdk.api.operation.ReportOperation;
import br.com.setia.engage.sdk.engagesdk.api.operation.RewardOperation;
import br.com.setia.engage.sdk.engagesdk.api.operation.TriggerOperation;
import br.com.setia.engage.sdk.engagesdk.api.operation.base.Network;
import br.com.setia.engage.sdk.engagesdk.model.engine.Settings;
import br.com.setia.engage.sdk.engagesdk.model.engine.Trigger;
import br.com.setia.engage.sdk.engagesdk.model.person.Person;
import br.com.setia.engage.sdk.engagesdk.model.report.PersonPoints;
import br.com.setia.engage.sdk.engagesdk.model.reward.Reward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EngageSdkApplicationTests {

    //region Sample Data
    private static final String userName = "smiguelnet";
    private static final String userEmail = "sergio@smiguel.net";
    private static final String source = "ninjastickers";
    //endregion

    //region Status
    private static final int STATUS_SUCCESS = 0;
    //endregion

    private Network network = Network.setDevelopment("customer-ID", "customer-KEY");

    //region Trigger
    @Test
    void testTrigger_GetItems() throws NetworkOperationException {
        TriggerOperation triggerOperation = getTriggerOperation();
        List<Trigger> items = triggerOperation.getItems();
        Assertions.assertTrue(!CollectionUtils.isEmpty(items));
    }

    @Test
    void testTrigger_PostReview() throws NetworkOperationException {
        TriggerOperation triggerOperation = getTriggerOperation();

        TriggerRequestMessage triggerRequestMessage = initTriggerRequest("PostReview");
        //ATTRIBUTES
        triggerRequestMessage.setAttributes(new ArrayList<>());
        triggerRequestMessage.getAttributes().add(getSimpleMap("has_photo", true));
        triggerRequestMessage.getAttributes().add(getSimpleMap("has_video", true));
        triggerRequestMessage.getAttributes().add(getSimpleMap("lines", 150));

        //POST REQUEST
        TriggerResponseMessage response = triggerOperation.invoke(triggerRequestMessage);
        Assertions.assertNotNull(response);
    }

    @Test
    void testTrigger_Registration() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("Registration");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_Login1Day() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("LoginOneTimeDay");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_LoginOneTimeWeek() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("LoginOneTimeWeek");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_AccountActivation() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("AccountActivation");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_OpenFirstStickersPack() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("OpenFirstStickersPack");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_OpenStickersPack() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("OpenStickersPack");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_PutSellOfferInMarketplace() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("PutSellOfferInMarketplace");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_PutBuyOfferInMarketplace() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("PutBuyOfferInMarketplace");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_FindFistRareInPack() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("FindFistRareInPack");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_FindFistEpicInPack() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("FindFistEpicInPack");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_FindFistLegendInPack() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("FindFistLegendInPack");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompletePersonalProfile() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompletePersonalProfile");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CreatePersonalCollection() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CreatePersonalCollection");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMoto3Riders() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMoto3Riders");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMoto3Bikes() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMoto3Bikes");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMoto3Actions() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMoto3Actions");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMoto2Riders() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMoto2Riders");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMoto2Bikes() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMoto2Bikes");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMoto2Actions() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMoto2Actions");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMotoGpRiders() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMotoGpRiders");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMotoGpBikes() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMotoGpBikes");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_ShareCollectionOnFacebookMotoGpActions() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("ShareCollectionOnFacebookMotoGpActions");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteFirstAlbum() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteFirstAlbum");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMoto3Riders() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMoto3Riders");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMoto3Bikes() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMoto3Bikes");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMoto3Actions() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMoto3Actions");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMoto2Riders() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMoto2Riders");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMoto2Bikes() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMoto2Bikes");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMoto2Actions() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMoto2Actions");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMotoGpRiders() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMotoGpRiders");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMotoGpBikes() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMotoGpBikes");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumMotoGpActions() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumMotoGpActions");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_Reach20TradesCompleted() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("Reach20TradesCompleted");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumCircuits() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumCircuits");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_CompleteAlbumLegends() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("CompleteAlbumLegends");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    @Test
    void testTrigger_Reach40TradesCompleted() throws NetworkOperationException {
        TriggerResponseMessage response = invokeGenericTrigger("Reach40TradesCompleted");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatus(), STATUS_SUCCESS);
    }

    private TriggerResponseMessage invokeGenericTrigger(String triggerName) throws NetworkOperationException {
        TriggerOperation triggerOperation = getTriggerOperation();
        TriggerRequestMessage triggerRequestMessage = initTriggerRequest(triggerName);
        //POST REQUEST
        return triggerOperation.invoke(triggerRequestMessage);
    }

    private TriggerOperation getTriggerOperation() {
        return new TriggerOperation(network);
    }

    private TriggerRequestMessage initTriggerRequest(String triggerName) {
        Person person = new Person();
        person.setUserName(userName);
        person.setEmail(userEmail);

        TriggerRequestMessage triggerRequestMessage = new TriggerRequestMessage();
        triggerRequestMessage.setName(triggerName);
        triggerRequestMessage.setPerson(person);
        triggerRequestMessage.setSource(source);

        return triggerRequestMessage;
    }

    private Map<String, Object> getSimpleMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
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

    //region Report
    @Test
    void testReport_GetLeaderboard() throws NetworkOperationException {
        ReportOperation reportOperation = new ReportOperation(network);
        List<PersonPoints> leaderboard = reportOperation.getLeaderboard();
        Assertions.assertNotNull(leaderboard);
    }
    //endregion

    //region Person
    @Test
    void testPerson_GetProfile() throws NetworkOperationException {
        PersonOperation personOperation = new PersonOperation(network);
        PersonResponseMessage profile = personOperation.getProfile(userName);
        Assertions.assertNotNull(profile);
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
