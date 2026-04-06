package com.example.medsecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedsecureApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedsecureApplication.class, args);
        System.out.println("\n✅ MedSecure Backend Started on http://localhost:8081");
        System.out.println("✅ Database: medsecure_db");
        System.out.println("✅ API Endpoints:");
        System.out.println("   - POST /api/auth/register");
        System.out.println("   - POST /api/auth/login");
        System.out.println("   - GET  /api/verify");
        System.out.println("   - POST /api/history/add");
        System.out.println("   - GET  /api/history/user/{userId}");
        System.out.println("   - GET  /api/faqs\n");
    }
}