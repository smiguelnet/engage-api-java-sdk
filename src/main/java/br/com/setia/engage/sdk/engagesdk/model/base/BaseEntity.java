package br.com.setia.engage.sdk.engagesdk.model.base;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Date;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class BaseEntity {

    private String id;
    private boolean active;
    private Date insertDate;
    private Date updateDate;
}
