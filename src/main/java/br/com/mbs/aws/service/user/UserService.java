package br.com.mbs.aws.service.user;

import br.com.mbs.aws.entity.User;
import br.com.mbs.aws.repository.UserRepository;
import br.com.mbs.aws.service.aws.s3.BucketName;
import br.com.mbs.aws.service.aws.s3.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private S3Service s3Service;


    @Autowired
    private UserRepository userRepository;

    public Integer saveUser(User user) {
        s3Service.createFileBucket(user, BucketName.MARCELO_TEST_BUCKET_3.getValue());
        var userSaved = userRepository.save(user);
        return userSaved.getId();
    }

    public List<User> getAllUser() {
        var returnListUser = new ArrayList<User>();
        userRepository
                .findAll()
                .iterator()
                .forEachRemaining(returnListUser::add);
        return returnListUser;
    }


}
