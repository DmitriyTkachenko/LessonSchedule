package scheduleApp.config;

import org.springframework.context.annotation.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import scheduleApp.service.UserDetailsServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("scheduleApp")
@Import({ SecurityConfig.class })
@ImportResource({"file:**/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }

}