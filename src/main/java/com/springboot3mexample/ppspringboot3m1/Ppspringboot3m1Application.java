package com.springboot3mexample.ppspringboot3m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class Ppspringboot3m1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ppspringboot3m1Application.class, args);
        openHomePage();
    }

    private static void openHomePage() {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/users");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}
