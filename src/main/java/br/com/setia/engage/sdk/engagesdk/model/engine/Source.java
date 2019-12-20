package br.com.setia.engage.sdk.engagesdk.model.engine;

import br.com.setia.engage.sdk.engagesdk.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Source extends BaseEntity {

    private String name;
    private String description;
    private String url;
}
