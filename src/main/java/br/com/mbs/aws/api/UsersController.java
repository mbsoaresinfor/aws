package br.com.mbs.aws.api;

import br.com.mbs.aws.service.s3.BucketName;
import br.com.mbs.aws.service.s3.S3Service;
import br.com.mbs.aws.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("users")
@RestController("users")
public class UsersController {


    @Autowired
    private S3Service s3Service;
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

        s3Service.createFileBucket(user, BucketName.MARCELO_TEST_BUCKET_3.getValue());

        listUser.add(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contId);
    }
}
