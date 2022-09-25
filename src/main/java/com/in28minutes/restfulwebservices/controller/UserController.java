package com.in28minutes.restfulwebservices.controller;

import com.in28minutes.restfulwebservices.entity.User;
import com.in28minutes.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.restfulwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userDaoService.getUserList();
    }

    @GetMapping("/user/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user =  userDaoService.getUserById(id);

        if(user==null){
            throw new UserNotFoundException("ID Not Found"+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAllUser());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable int id){
         userDaoService.deleteById(id);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

         User savedUser = userDaoService.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

      return  ResponseEntity.created(location).build();
    }
}
