package ru.medov.auth_session_spring5.service;

import org.springframework.stereotype.Service;
import ru.medov.auth_session_spring5.domain.Person;
import ru.medov.auth_session_spring5.repository.PersonRepo;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Optional<Person> getPersonByName(String name){
        return personRepo.findByName(name);
    }
}
