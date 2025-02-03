package org.prvn.labs.order.processing.orderservice.web.client.config;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApacheHTTPRestTemplateCustomizer implements RestTemplateCustomizer {

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(getRequestFactory());
    }

    private ClientHttpRequestFactory getRequestFactory() {

        //Pool
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(50);

        // Http Client
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                // can customize the request Config
                .setDefaultRequestConfig(RequestConfig.DEFAULT)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);

        //Http RequestFactory
        return requestFactory;
    }
}
