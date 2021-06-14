package com.herokuapp.edenredkatyucyateste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class EdenredkatyucyatesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdenredkatyucyatesteApplication.class, args);
	}
	@RequestMapping("/")
	  String index() {
	    return "redirect:/index.html";
	  }
}
