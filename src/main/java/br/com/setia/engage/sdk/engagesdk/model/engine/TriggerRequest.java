package br.com.setia.engage.sdk.engagesdk.model.engine;

import br.com.setia.engage.sdk.engagesdk.model.person.Person;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TriggerRequest {

    private Trigger trigger;
    private Person person;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date requestDate;

    private List<Map<String, Object>> attributes;
}
