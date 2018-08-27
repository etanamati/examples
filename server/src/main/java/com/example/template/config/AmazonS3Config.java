package com.example.template.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonS3Config {
    @Value("${aws.s3.access-key-id}")
    private String awsId;
    @Value("${aws.s3.access-key-secret}")
    private String awsKey;
    @Value("${aws.s3.region}")
    private String region;
    @Value("${aws.s3.bucket-name}")
    private String s3BucketName;

    public String getRegion() {
        return region;
    }

    public String getS3BucketName() {
        return s3BucketName;
    }

    @Bean
    public AmazonS3 s3Client() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(awsId, awsKey);

        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

    }

}
