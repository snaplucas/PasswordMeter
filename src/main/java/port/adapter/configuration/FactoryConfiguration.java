package port.adapter.configuration;

import application.interfaces.IPasswordAppService;
import application.services.PasswordAppService;
import domain.model.interfaces.IPasswordService;
import domain.model.services.PasswordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfiguration {

    @Bean
    public IPasswordAppService getPasswordAppService() {
        return new PasswordAppService();
    }

    @Bean
    IPasswordService getPasswordService() {
        return new PasswordService();
    }
}
