package br.com.mbs.aws.service.aws.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.waiters.S3Waiter;

import java.io.Serializable;
import java.util.UUID;

@Service
public class S3Service {

    @Autowired
    private S3Client s3Client;

    public void createFileBucket(Serializable content, String bucketName) {

        S3Waiter waiter = s3Client.waiter();
        PutObjectRequest putOb = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(UUID.randomUUID() + ".txt")
                .build();

        s3Client.putObject(putOb, RequestBody.fromString(content.toString()));
        System.out.println("create file successfully");
    }
}
