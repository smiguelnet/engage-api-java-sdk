package br.com.setia.engage.sdk.engagesdk.model.person;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class PersonProfile {

    private Long statusPoints;
    private Long virtualCurrency;
    private PersonProfileLevel level;
    private List<PersonProfileEvolution> history;
}
