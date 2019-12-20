package br.com.setia.engage.sdk.engagesdk.requests.trigger;

import br.com.setia.engage.sdk.engagesdk.requests.status.StatusResponse;
import br.com.setia.engage.sdk.engagesdk.model.person.Person;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TriggerResponseMessage {

    private String name;
    private String source;
    private Person person;
    private StatusResponse status;
}
