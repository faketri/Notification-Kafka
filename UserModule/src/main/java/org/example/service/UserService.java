package org.example.service;

import org.example.entity.Users;
import org.example.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Collection<Users> findAll(){
        return usersRepository.findAll();
    }

    public Users save(Users users){
        return usersRepository.save(users);
    }

    public Collection<Users> saveAll(Iterable<Users> users){
        return usersRepository.saveAll(users);
    }
}
