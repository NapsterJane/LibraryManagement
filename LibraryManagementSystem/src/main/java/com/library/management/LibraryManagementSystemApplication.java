package com.library.management;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.library.management.controller.MainController;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		//for create upload folder if not exists 
		new File(MainController.uploadDirectory).mkdir();
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

}
