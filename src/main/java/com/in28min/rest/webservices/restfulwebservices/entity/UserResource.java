package com.in28min.rest.webservices.restfulwebservices.entity;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28min.rest.webservices.restfulwebservices.dao.UserDaoService;

import jakarta.validation.Valid;

@RestController
public class UserResource {
    
    private UserDaoService service;
    
    @Autowired
    public UserResource(UserDaoService userDaoService) {
        this.service = userDaoService;
    }
    
    // GET "/users"
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }
    
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId) {
        User user = service.findById(userId);
        
        if (user == null) {
            throw new UserNotFoundException("id: " + userId);
        }
        return user;
    }
    
    // the data we're sending is in the request body so we use @RequestBody
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}") // adds a path "/{id}", appended
                            .buildAndExpand(savedUser.getId()) // replace {id} with id from User.getId()
                                .toUri(); // convert to uri and return it back to location variable
        
        // return uri of created user? location - /users/4
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/users/{userId}")
    public void deleteUserById(@PathVariable int userId) {
        service.deleteById(userId);

    }
    
    
}
