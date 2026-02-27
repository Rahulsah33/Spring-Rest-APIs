package com.RR.first_spring.app;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private Map<Integer, User> userDb = new HashMap<>();

    @PostMapping
    public ResponseEntity<String> createUser (@RequestBody User user) {
        System.out.println(user.getEmail());
        userDb.putIfAbsent(user.getId(), user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");

    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (!userDb.containsKey(user.getId()))
//            return ResponseEntity.notFound().build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            userDb.put(user.getId(), user);
//        return ResponseEntity.status(HttpStatus.OK).body(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        if (!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        userDb.remove(id);
        return ResponseEntity.ok("User Deleted Successfully !");
    }

    @GetMapping()
    public List<User> getUsers () {
        return new ArrayList<>(userDb.values());
    }


    //  => user/101
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser (@PathVariable int id) {
        if (!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(userDb.get(id));
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder
            (
                    @PathVariable("userId") int id,
                    @PathVariable int orderId
            ) {
        System.out.println("ORDER ID:" + orderId);

        if (!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(userDb.get(id));
    }


    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser (
            @RequestParam(required = false, defaultValue = "Rahul") String name
    ) {
        System.out.println(name);

        List<User> users = userDb.values().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .toList();

        return ResponseEntity.ok(new ArrayList<>(userDb.values()));

    }

}
