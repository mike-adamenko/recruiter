package com.heavenhr.recruiter.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "person_data")
class Person {

    @Id
    Long id;

    @Column(name = "first_name" , nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }
}

@Service
class PersonService {
    @Autowired
    PersonRepository personRepository;

    List<Person> findAll() {
        List persons = new ArrayList();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

}

@Repository
interface PersonRepository extends CrudRepository<Person, Long> {}
