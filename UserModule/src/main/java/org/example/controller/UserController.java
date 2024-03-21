package org.example.controller;

import org.example.entity.Users;
import org.example.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Collection<Users> findAll(){
        return userService.findAll();
    }

    @RequestMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Users save(@RequestBody Users users){
        return userService.save(users);
    }

    @RequestMapping(path = "/saveAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Collection<Users> saveAll(@RequestBody Iterable<Users> users){
        return userService.saveAll(users);
    }
}
