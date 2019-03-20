package com.chris.cursomc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chris.cursomc.services.S3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\Users\\jeferson\\Pictures\\Saved Pictures\\75fee1f8e557124f7996877488d08a0d5f8284f4v2_128.jpg");  
		
		
		
	}

}
