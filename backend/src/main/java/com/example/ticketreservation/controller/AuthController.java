package com.example.ticketreservation.controller;
import org.springframework.web.bind.annotation.*;
import com.example.ticketreservation.entity.User;
import com.example.ticketreservation.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo){
        this.repo = repo;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setRole("USER");
        return repo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        User db = repo.findByEmail(user.getEmail());
        if(db != null && db.getPassword().equals(user.getPassword())){
            return "Login Success";
        }
        return "Invalid Credentials";
    }
}