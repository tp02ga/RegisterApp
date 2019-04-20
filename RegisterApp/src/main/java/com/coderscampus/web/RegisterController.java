package com.coderscampus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.domain.User;
import com.coderscampus.repository.UserRepository;

@Controller
public class RegisterController {
  
  @Autowired
  private UserRepository userRepo;
  
  @GetMapping("/register")
  public String getRegister(ModelMap model) {
    model.put("users", userRepo.findAll());
    
    User user = new User();
    
    model.put("user", user);
    
    return "register";
  }
  
  @PostMapping("/register")
  public String postRegister(User user) {
    userRepo.save(user);
    return "redirect:/register";
  }
}
