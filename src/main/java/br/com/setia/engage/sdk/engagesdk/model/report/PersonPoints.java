package br.com.setia.engage.sdk.engagesdk.model.report;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class PersonPoints {
    private String person;

    @JsonProperty(value = "total_status_points")
    private long totalStatusPoints;

    @JsonProperty(value = "total_virtual_currency")
    private long totalVirtualCurrency;
}
