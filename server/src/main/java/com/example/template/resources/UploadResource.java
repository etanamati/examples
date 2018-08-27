package com.example.template.resources;

import java.net.URL;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.template.service.AmazonService;

@RestController
@RequestMapping("/upload-files")
public class UploadResource {

	private final AmazonService amazonService;
	
	public UploadResource(AmazonService amazonService) {
		this.amazonService = amazonService;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/url-envio")
	public ResponseEntity<URL> getUrlEnvio(@RequestParam String name){
		return ResponseEntity.ok().body(this.amazonService.getUrlS3Amazon(name));
	}
}
