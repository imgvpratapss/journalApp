package net.engineeringdigest.journalApp.controller;


import lombok.var;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.entity.excception.CustomExceptionMessage;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Map> getAllUsers(){
       return userService.users();
    }

    @GetMapping("/id")
    public ResponseEntity<Object> getUserById(@RequestParam ObjectId id){
        return userService.findById(id).map(user-> new ResponseEntity<>((Object)user , HttpStatus.OK)).orElseGet(()-> new ResponseEntity<>(User.builder().message(CustomExceptionMessage.builder().message("").code(HttpStatus.NOT_FOUND.value()).httpStatus(HttpStatus.NOT_FOUND).build()).build(),HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveUser(user);
    }

    private ResponseEntity<Object> findUesrByname(String username){
        return userService.findByUserName(username).map(user -> new ResponseEntity<>((Object)user,HttpStatus.OK )).orElseGet(()-> new ResponseEntity<>(User.builder().message(CustomExceptionMessage.builder().message("").code(HttpStatus.NOT_FOUND.value()).httpStatus(HttpStatus.NOT_FOUND).build()).build(),HttpStatus.NOT_FOUND));
    }
    @PutMapping
    public Map<ObjectId, User> updateUser(@RequestBody User user)  {
       var authentication=  SecurityContextHolder.getContext().getAuthentication();
        var oldUser= (User)  findUesrByname(authentication.getName()).getBody();
        if(oldUser==null)
            throw new NullPointerException("No record found");
        if(oldUser!=null) {
            oldUser.setPassword(user.getPassword()!=null && !user.getPassword().equals("")? user.getPassword() : oldUser.getPassword());
            oldUser.setEmail(user.getEmail()!=null && !user.getEmail().equals("")? user.getEmail() : oldUser.getEmail());
            oldUser.setUserName(user.getUserName()!=null && !user.getUserName().equals("")? user.getUserName() : oldUser.getUserName());
        }
        return userService.saveUser(oldUser);
    }


}
