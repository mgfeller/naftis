package net.mgfeller.naftis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {

    }

    @PostConstruct
    public void setUp() {
        register(BookController.class);
        register(GenericExceptionMapper.class);
    }
}
