package br.com.setia.engage.sdk.engagesdk.model.notification;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Notification {

    private String name;
    private String message;
    private boolean phone;
    private boolean email;
}
