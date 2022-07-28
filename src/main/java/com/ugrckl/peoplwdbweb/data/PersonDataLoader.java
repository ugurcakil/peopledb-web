package com.ugrckl.peoplwdbweb.data;

import com.ugrckl.peoplwdbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Person> people = null;
        if (personRepository.count() == 0) {
            people = List.of(
                    new Person(null,"Ferit","Snake", "jake_snake@gmail.com", LocalDate.of(1970,1,1), new BigDecimal(50000)),
                    new Person(null,"Daria","Smith", "sarah_smith@gmail.com", LocalDate.of(1980,5,1), new BigDecimal(60000)),
                    new Person(null,"Jenny","Jackson", "jnjk@gmail.com",LocalDate.of(1995,3,1),new BigDecimal(70000)),
                    new Person(null,"Dany","Samson", "ugrckl@gmail.com", LocalDate.of(1990,6,1),new BigDecimal(80000)),
                    new Person(null,"Bobby","Kim", "bobkim@gmail.com" , LocalDate.of(1960,8,1),new BigDecimal(90000))

            );
        }
        personRepository.saveAll(people);
    }
}
