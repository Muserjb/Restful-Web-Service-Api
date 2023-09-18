package com.example.websevices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoServices userDaoService;

    UserResource(UserDaoServices userDaoServices){
        this.userDaoService = userDaoServices;
    }


    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        List<User> allUsers = userDaoService.findAll();
        return allUsers;
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = userDaoService.findOneUser(id);
        if (user == null) {
            throw  new UserNotFoundException("id of the user is not found " + id);

        }
        return user;
    }


    @DeleteMapping(path = "/users/{id}")
    public void deleteById(@PathVariable int id){
        userDaoService.deleteById(id);
    }



    /*@PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User save = userDaoService.saveUser(user);
        //  location  /users/4  => /users/{id}     => /users/ user.getId()
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

     */

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User save = userDaoService.saveUser(user);
        //  location  /users/4  => /users/{id}     => /users/ user.getId()
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }


 }