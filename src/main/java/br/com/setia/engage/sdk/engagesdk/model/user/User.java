package br.com.setia.engage.sdk.engagesdk.model.user;

import br.com.setia.engage.sdk.engagesdk.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class User extends BaseEntity {

    @JsonProperty(value = "user_name")
    private String userName;

    private String email;
    private Set<Role> roles;

}
