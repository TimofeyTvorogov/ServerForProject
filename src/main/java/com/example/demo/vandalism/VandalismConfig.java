package com.example.demo.vandalism;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class VandalismConfig {

@Bean
CommandLineRunner commandLineRunner(VandalismRepository repository){

    return args -> {
        /*Vandalism testPlace1 = new Vandalism(55.79,49.12, "Казань","default type","default object",0L,false);
        Vandalism testPlace2 = new Vandalism(45.79,38.98, "Краснодар","default type","default object",0L,false);
        Vandalism testPlace3 = new Vandalism(55.75,37.62, "Москва","default type","default object",0L,false);
        Vandalism testPlace4 = new Vandalism(52.3,104.3, "Иркутск","default type","default object",0L,false);
        repository.saveAll(List.of(testPlace1,testPlace2,testPlace3,testPlace4));*/
      repository.saveAll(repository.findAll());

    };

}
}


