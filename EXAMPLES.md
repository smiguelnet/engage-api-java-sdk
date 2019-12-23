# engage-api-java-sdk
## List available Rewards
```java
Network network = Network.setDevelopment("Your-Customer-ID", "Your-Customer-KEY");
RewardOperation rewardOperation = new RewardOperation(network);
List<Reward> items = rewardOperation.getItems();
```

## List available Triggers
```java
Network network = Network.setDevelopment("Your-Customer-ID", "Your-Customer-KEY");
TriggerOperation triggerOperation = new TriggerOperation(network);
List<Trigger> items = triggerOperation.getItems();
```

## Invoke a Simple Trigger
```java
Network network = Network.setDevelopment("Your-Customer-ID", "Your-Customer-KEY");
TriggerOperation triggerOperation = new TriggerOperation(network);
TriggerRequestMessage triggerRequestMessage = new TriggerRequestMessage();
triggerRequestMessage.setName("Registration");

//POST REQUEST
TriggerResponseMessage response = triggerOperation.invoke(triggerRequestMessage);
```

## Invoke a Trigger with custom attributes 
```java
Network network = Network.setDevelopment("Your-Customer-ID", "Your-Customer-KEY");
TriggerOperation triggerOperation = new TriggerOperation(network);

TriggerRequestMessage triggerRequestMessage = new TriggerRequestMessage();
triggerRequestMessage.setName("PostReview");
triggerRequestMessage.setSource("ninjastickers");

Person person = new Person();
person.setUserName("smiguelnet");
person.setEmail("sergio@smiguel.net");
triggerRequestMessage.setPerson(person);

//ATTRIBUTES
triggerRequestMessage.setAttributes(new ArrayList<>());
triggerRequestMessage.getAttributes().add(getSimpleMap("has_photo", true));
triggerRequestMessage.getAttributes().add(getSimpleMap("has_video", true));
triggerRequestMessage.getAttributes().add(getSimpleMap("lines", 150));

//POST REQUEST
TriggerResponseMessage response = triggerOperation.invoke(triggerRequestMessage);
```

## Leaderboard
```java
Network network = Network.setDevelopment("Your-Customer-ID", "Your-Customer-KEY");
ReportOperation reportOperation = new ReportOperation(network);
List<PersonPoints> leaderboard = reportOperation.getLeaderboard();
```