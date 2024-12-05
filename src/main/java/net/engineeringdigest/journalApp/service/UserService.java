package net.engineeringdigest.journalApp.service;


import lombok.var;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private final PasswordEncoder  passwordEncoder =new BCryptPasswordEncoder();

    public Map<ObjectId, User> saveNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(!user.getRoles().isEmpty())
             user.setRoles(Stream.concat(user.getRoles().stream(),Arrays.asList("USER").stream()).collect(Collectors.toList()));
        else
             user.setRoles(Arrays.asList("USER"));
        var entry = userRepo.save(user);
        var value=(Map)  new HashMap<>();
        value.put(entry.getId(), entry);
        return  value;

    }

    public Map<ObjectId, User> saveUser(User user) {
        var entry = userRepo.save(user);
        var value=(Map)  new HashMap<>();
        value.put(entry.getId(), entry);
        return  value;

    }

    public List<Map> users() {
        var users = userRepo.findAll();
        List<Map> list  = new ArrayList<>();
        var userMap =(Map)  new HashMap<>();
       if(! users.isEmpty())
            users.stream().forEach(journalEntry -> {
                userMap.put(journalEntry.getId(),journalEntry);
            });
        list.add(userMap);
        return list;
    }

    public Optional<User> findById(ObjectId jid) {
        return userRepo.findById(jid);
    }

    public Boolean deleteUserById(ObjectId id) {
         if(id!=null){
             var user= findById(id);
             userRepo.deleteById(id);
             return Boolean.TRUE;
         }else
             return Boolean.FALSE;
    }

    public Optional<User> findByUserName(String username){
       return userRepo.findByUserName(username);
    }
}
