package com.example.template.service;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.example.template.config.AmazonS3Config;

@Service
public class AmazonService {
	
	@Autowired
	private AmazonS3Config amazonS3Config;
	
	public URL getUrlS3Amazon(String key) {

        // Set the presigned URL to expire after one hour.
        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 1;
        expiration.setTime(expTimeMillis);
        
        // Generate the presigned URL.
        GeneratePresignedUrlRequest generatePresignedUrlRequest = 
                new GeneratePresignedUrlRequest(amazonS3Config.getS3BucketName(), key)
                .withMethod(HttpMethod.PUT)
                .withExpiration(expiration);
        
        URL url = amazonS3Config.s3Client().generatePresignedUrl(generatePresignedUrlRequest);
		
		return url;
	}
}
