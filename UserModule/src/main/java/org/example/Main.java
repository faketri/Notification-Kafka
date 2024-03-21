package org.example;

import com.github.javafaker.Faker;
import org.example.entity.Product;
import org.example.entity.Users;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductService productService, UserService userService){
        return args -> {
            Faker faker = new Faker();
            List<Users> users = new ArrayList<>();
            for (int i = 0; i < 100; i++)
                users.add(new Users(null, faker.name().name()));


            userService.saveAll(users);

            Product product = new Product();
            product.setName("TESTIROVKA");

            productService.save(product);

            product.getUsersSubscribe().addAll(
                    users.stream()
                            .filter((user) -> user.getLogin().length() > 5)
                            .toList());

            product.setQuantity(10);

            productService.save(product);
        };
    }
}