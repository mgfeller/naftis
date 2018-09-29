package net.mgfeller.naftis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NaftisApplication {


    /*
        https://spring.io/guides/gs/securing-web/
        https://dzone.com/articles/configuring-spring-boot-on-kubernetes-with-secrets?fromrel=true
    */
    public static void main(String[] args) {
        SpringApplication.run(NaftisApplication.class, args);
    }
}
