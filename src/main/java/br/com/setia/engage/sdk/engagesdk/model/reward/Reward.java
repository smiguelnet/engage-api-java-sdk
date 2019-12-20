package br.com.setia.engage.sdk.engagesdk.model.reward;

import br.com.setia.engage.sdk.engagesdk.enumerator.RewardType;
import br.com.setia.engage.sdk.engagesdk.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Reward extends BaseEntity {

    private RewardType type;
    private String name;

    @JsonProperty(value = "friendly_name")
    private String friendlyName;


    private String reference;
    private String description;

    @JsonProperty(value = "image_url")
    private String imageUrl;

    private Map<String, String> attributes;
}
