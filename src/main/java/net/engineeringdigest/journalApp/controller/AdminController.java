package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private  UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAll(){
       List<?> users=  userService.users();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestBody User user){
        user.setRoles(Arrays.asList("ADMIN"));
        return new ResponseEntity<>(userService.saveNewUser(user),HttpStatus.CREATED);
    }


}
