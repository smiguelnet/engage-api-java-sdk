package br.com.setia.engage.sdk.engagesdk.api.operation;

import lombok.Data;

@Data
public class Network {

    public static final String PRODUCTION = "https://singular-engage-api.herokuapp.com/api";
    public static final String DEVELOPMENT = "http://localhost:8080/api";

    private String url;
    private String apiCustomerId;
    private String apiCustomerKey;

    private Network(String url, String apiCustomerId, String apiCustomerKey) {
        this.url = url;
        this.apiCustomerId = apiCustomerId;
        this.apiCustomerKey = apiCustomerKey;
    }

    public static Network setProduction(String apiCustomerId, String apiCustomerKey) {
        return new Network(PRODUCTION, apiCustomerId, apiCustomerKey);
    }

    public static Network setDevelopment(String apiCustomerId, String apiCustomerKey) {
        return new Network(DEVELOPMENT, apiCustomerId, apiCustomerKey);
    }
}
