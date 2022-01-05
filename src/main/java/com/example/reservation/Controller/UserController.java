package com.example.reservation.Controller;

import com.example.reservation.Entity.Flight;
import com.example.reservation.Entity.User;
import com.example.reservation.Repository.UserRepositoryJPA;
import com.example.reservation.Service.UserService;
import com.example.reservation.exception.FlightNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @PostMapping
    public ResponseEntity registrationUser(@RequestBody User user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add new user");
        }
    }

    @GetMapping(value = "/exist/{passportInfo}")
    public ResponseEntity existsByPassportinfoAllIgnoreCase(@PathVariable String passportInfo) {
        try {
            boolean exists = userRepositoryJPA.existsByPassportinfoAllIgnoreCase(passportInfo);
            if (exists) {
                return ResponseEntity.ok("User exists");
            } else {
                return ResponseEntity.badRequest().body("User doesn't exists");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to search");
        }
    }

    @GetMapping(value = "/all")
    public List<User> getall() {
        try {
            List<User> users = userRepositoryJPA.findAll();
            return users;
        } catch (Exception e) {
            List<User> emplistuser = Collections.emptyList();
            return emplistuser;

        }
    }


    @GetMapping(value = "/{userID}")
    public User getUser(@PathVariable Long userID) {
        Optional<User> optionaluser = userService.findById(userID);
        if (optionaluser.isPresent()) {
            return optionaluser.get();
        }

        throw new FlightNotFound(userID.toString());
    }
}
