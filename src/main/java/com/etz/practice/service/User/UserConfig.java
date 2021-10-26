package com.etz.practice.service.User;

import com.etz.practice.model.UserModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args ->{
            UserModel tams= new UserModel(
                    "Tams",
                    "Dev",
                    "Backend"
                );
            UserModel esther= new UserModel(
                    "esther",
                    "Dike",
                    "UI/UX"
            );
            repository.saveAll(List.of(tams,esther));
        };
    }
}
