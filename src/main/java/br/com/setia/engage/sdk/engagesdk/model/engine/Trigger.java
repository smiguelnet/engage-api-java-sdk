package br.com.setia.engage.sdk.engagesdk.model.engine;


import br.com.setia.engage.sdk.engagesdk.model.base.BaseEntity;
import br.com.setia.engage.sdk.engagesdk.model.reward.RewardComposition;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Trigger extends BaseEntity {

    private String name;
    private Source source;
    private List<TriggerAttribute> attributes;
    private RewardComposition rewardComposition;
    private TriggerGoal goal;

}
