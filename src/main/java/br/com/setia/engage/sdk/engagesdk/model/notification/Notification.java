package br.com.setia.engage.sdk.engagesdk.model.notification;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Notification {

    @JsonProperty
    private String name;

    @JsonProperty
    private String message;

    @JsonProperty
    private boolean phone;

    @JsonProperty
    private boolean email;
}
