package br.com.setia.engage.sdk.engagesdk.model.person;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Date;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class PersonProfileEvolution {

    private Long statusPoints;
    private Long virtualCurrency;
    private String level;
    private String operation;


    private Date date;

    private String description;
}
