package com.example.demospring03.security;

import com.example.demospring03.dao.UserDao;
import com.example.demospring03.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegistrationController {
  
  private UserDao userRepo;
  private PasswordEncoder passwordEncoder;

 public RegistrationController(
          UserDao userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }
  
  @PostMapping
  public int processRegistration(RegistrationForm form) {
    int i = userRepo.insertSelective(form.toUser(passwordEncoder));
    return i;
  }


  @GetMapping("/{id}")
  public Optional<User> getUserById(@PathVariable("id") String id) {
    User user1 = userRepo.selectByPrimaryKey(id);
    Optional<User> user = Optional.ofNullable(user1);
    return user;
  }
}
