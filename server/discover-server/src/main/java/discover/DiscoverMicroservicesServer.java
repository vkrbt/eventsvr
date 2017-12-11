package discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverMicroservicesServer {
    public static void main(String[] args) {
        SpringApplication.run(DiscoverMicroservicesServer.class, args);
    }
}