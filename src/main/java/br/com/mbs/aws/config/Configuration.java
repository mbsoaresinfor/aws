package br.com.mbs.aws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.crt.auth.credentials.CredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.access-key}")

    private String secretKey;


    @Bean
    public AwsCredentialsProvider getAwsCredentialsProvider(){
        return StaticCredentialsProvider
                .create(AwsBasicCredentials.create( accessKey,secretKey));
    }

    @Bean
    public S3Client createS3Client(){
        Region region = Region.SA_EAST_1;
        S3Client s3 = S3Client.builder()
                .credentialsProvider(getAwsCredentialsProvider())
                .region(region)
                .build();
        return s3;
    }
}
