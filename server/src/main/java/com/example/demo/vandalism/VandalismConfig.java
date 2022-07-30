package com.example.demo.vandalism;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VandalismConfig {

@Bean
CommandLineRunner commandLineRunner(VandalismRepository repository){

    return args -> {

      repository.saveAll(repository.findAll());

    };

}
}


