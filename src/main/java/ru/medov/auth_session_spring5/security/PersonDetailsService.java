package ru.medov.auth_session_spring5.security;

import ch.qos.logback.classic.spi.IThrowableProxy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.medov.auth_session_spring5.security.PersonDetails;
import ru.medov.auth_session_spring5.service.PersonService;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonService personService;

    public PersonDetailsService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return personService.getPersonByName(s).map(PersonDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("user not found"));
    }

}
