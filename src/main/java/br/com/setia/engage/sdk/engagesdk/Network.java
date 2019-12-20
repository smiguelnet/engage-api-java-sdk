package br.com.setia.engage.sdk.engagesdk;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Network {
    private String url;

    public static final Network PRODUCTION = new Network("https://singular-engage-api.herokuapp.com/");

    //TODO deploy at AWS
    public static final Network DEVELOPMENT = new Network("https://singular-engage-api.herokuapp.com/");
}
