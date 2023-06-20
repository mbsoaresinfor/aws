package br.com.mbs.aws.api;

import br.com.mbs.aws.entity.User;
import br.com.mbs.aws.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
@RestController("users")
public class UsersController {


    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        System.out.println(">>> Processing getUser <<<");
        return ResponseEntity
                .ok()
                .body(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody User user){
        System.out.println(">>> Processing createUser: [" + user + "]<<<");

        var id = userService.saveUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(id);
    }
}
