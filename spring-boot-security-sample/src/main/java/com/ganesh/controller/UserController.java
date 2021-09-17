package com.ganesh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.User;
import com.ganesh.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  
  @GetMapping("/api/1.0/test")
  public String greeting() {
	  return "Wel Come To Test App!";
  }

  @PostMapping("/api/1.0/users")
  public User createUser(@RequestBody User user){
    return this.userService.save(user);
  }

  @PutMapping("/api/1.0/users/{id}")
  @PreAuthorize("@userAuthorizationService.canUpdate(principal.user.id, #id) or hasRole('ROLE_admin')")
  public User updateUser(@PathVariable long id, @RequestBody User user){
    return this.userService.updateUser(id, user);
  }
  
}

