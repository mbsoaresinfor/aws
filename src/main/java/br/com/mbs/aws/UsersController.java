package br.com.mbs.aws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("users")
@RestController("users")
public class UsersController {

    private List<User> listUser = new ArrayList<>();
    private static int contId;
    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        System.out.println(">>> Processing getUser <<<");
        return ResponseEntity
                .ok()
                .body(listUser);
    }

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody User user){
        System.out.println(">>> Processing createUser: [" + user + "]<<<");
        user.setId(++contId);
        listUser.add(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contId);
    }
}
