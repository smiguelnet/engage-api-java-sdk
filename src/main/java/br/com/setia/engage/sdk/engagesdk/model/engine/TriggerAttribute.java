package br.com.setia.engage.sdk.engagesdk.model.engine;

import br.com.setia.engage.sdk.engagesdk.enumerator.AttributeType;
import br.com.setia.engage.sdk.engagesdk.model.reward.RewardComposition;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TriggerAttribute {

    private String name;
    private AttributeType type;
    private boolean required;
    private RewardComposition rewardComposition;
}
