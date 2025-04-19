package org.pehlivanmert.rediscache.controller;

import lombok.RequiredArgsConstructor;
import org.pehlivanmert.rediscache.dto.CreateUserDto;
import org.pehlivanmert.rediscache.dto.UpdateUserDto;
import org.pehlivanmert.rediscache.modal.User;
import org.pehlivanmert.rediscache.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.createUser(createUserDto));
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserDto updateUserDto) {
        return new ResponseEntity<>(userService.updateUser(updateUserDto), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public User getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }
}
