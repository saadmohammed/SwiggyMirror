package com.example.SwiggyMirror.controller;

import com.example.SwiggyMirror.model.Food;
import com.example.SwiggyMirror.model.User;
import com.example.SwiggyMirror.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Page<User> getAllUser(@RequestParam(value = "page") int page,
                                  @RequestParam(value = "limit") int limit) {
        return userService.findByPage(PageRequest.of(page, limit));
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody User user) throws InterruptedException {
        userService.create(user);
    }

    @PutMapping(value = "update/{userId}")
    public User updateUser(@PathVariable(value = "userId") Integer userId, @RequestBody User user) {
        return userService.updateUser(user, userId);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer taskId) {
        userService.deleteById(taskId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
