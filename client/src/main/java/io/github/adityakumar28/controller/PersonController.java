package io.github.adityakumar28.controller;

import io.github.adityakumar28.PersonRequest;
import io.github.adityakumar28.PersonResponse;
import io.github.adityakumar28.dto.PersonResponseDto;
import io.github.adityakumar28.service.PersonClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonClientService personClientService;

    @PostMapping("{name}/{age}")
    public PersonResponseDto getPersonName(@PathVariable("name") String name, @PathVariable("age") Integer age){
        PersonResponse person = personClientService.getNameByPerson(PersonRequest.newBuilder().setName(name).setAge(age).build());
        return PersonResponseDto
                .builder()
                .name(person.getName())
                    .build();
    }
}
