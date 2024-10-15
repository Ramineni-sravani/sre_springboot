package com.preeti.demoapplication.Controller;

import com.sravani.demoapplication.Model.RestUsers;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class HelloWorld {
    Map<String, RestUsers> allUsers = new HashMap<>();
    @GetMapping
    public Collection<RestUsers>getMethod() {
        return allUsers.values();
    }
    @PostMapping
    public String PostMethod(@RequestBody RestUsers userdetails) {
        RestUsers addValue = new RestUsers();
        addValue.setUserId(userdetails.getUserId());
        addValue.setName(userdetails.getName());
        addValue.setEmail(userdetails.getEmail());
        allUsers.put(userdetails.getUserId(), addValue);
        return "user added";
    }
    @PutMapping(path="/(userId)")
    public String putMethod(@PathVariable String userId, @RequestBody RestUsers userdetails) {
        if(allUsers.containsKey(userId)) {
            RestUsers addValue = new RestUsers();
            addValue.setUserId(userdetails.getUserId());
            addValue.setName(userdetails.getName());
            addValue.setEmail(userdetails.getEmail());
            allUsers.put(userId,addValue);
            return "user updated";
        }
        else{
            return "user not found";
        }
    }
    @DeleteMapping(path="/(userId)")
    public String deleteMethod(@PathVariable String userId) {
        if(allUsers.containsKey(userId)) {
            allUsers.remove(userId);
            return "user deleted successfully";
        }
        else{
            return "user not found";
        }
    }
}
