package br.com.setia.engage.sdk.engagesdk.model.reward;

import br.com.setia.engage.sdk.engagesdk.enumerator.RewardCompositionType;
import br.com.setia.engage.sdk.engagesdk.model.notification.Notification;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class RewardComposition {

    private Reward reward;
    private RewardCompositionType rewardCompositionType;
    private String rewardName;
    private Long amount;
    private Map<String, String> conditions;
    private Long statusPoints;
    private Long virtualCurrency;
    private Double randomSetting;
    private Double fixedSetting;
    private ChronoUnit chronoUnit;
    private List<Notification> notifications;
}
