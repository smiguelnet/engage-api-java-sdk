package br.com.setia.engage.sdk.engagesdk.api.message.trigger;

import br.com.setia.engage.sdk.engagesdk.model.person.Person;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TriggerRequestMessage {

    private String name;
    private String source;
    private Person person;
    private List<Map<String, Object>> attributes;
}
