package provider;

import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/3
 * Time: 17:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PCAPP {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
//        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(getHttpClient()));
        return new RestTemplate();
    }

    public CloseableHttpClient getHttpClient() {

        SocketConfig.Builder socketConfigBuilder = SocketConfig.custom();
        socketConfigBuilder.setSoTimeout(60000);
        socketConfigBuilder.setTcpNoDelay(true);
        SocketConfig socketConfig = socketConfigBuilder.build();

        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(500);
        connManager.setValidateAfterInactivity(500);
        connManager.setDefaultSocketConfig(socketConfig);

        HttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(3, true);

        return HttpClients.custom().setConnectionManager(connManager).setRetryHandler(retryHandler).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(PCAPP.class, args);
    }
}
