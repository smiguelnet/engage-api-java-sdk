package br.com.setia.engage.sdk.engagesdk.api.message.person;

import br.com.setia.engage.sdk.engagesdk.api.message.status.StatusResponse;
import br.com.setia.engage.sdk.engagesdk.model.person.Person;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class PersonResponseMessage {
    private Person person;
    private StatusResponse status;
}
