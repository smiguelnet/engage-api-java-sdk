package br.com.setia.engage.sdk.engagesdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import okhttp3.OkHttpClient;

@Data
@AllArgsConstructor
public class NetworkOperation {
    private Network network;

    private OkHttpClient httpClient;

}
