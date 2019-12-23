package br.com.setia.engage.sdk.engagesdk.model.engine;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TriggerGoal {

    private String name;
    private String message;

    @JsonProperty(value = "image_url")
    private String imageUrl;
}
