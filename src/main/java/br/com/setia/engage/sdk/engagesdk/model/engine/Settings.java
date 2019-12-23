package br.com.setia.engage.sdk.engagesdk.model.engine;

import br.com.setia.engage.sdk.engagesdk.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Map;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Settings extends BaseEntity {

    private Map<String, Long> levels;
    private boolean addPersonToDatabase;
}
