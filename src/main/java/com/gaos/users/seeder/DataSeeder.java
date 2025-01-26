package com.gaos.users.seeder;

import com.gaos.users.entities.User;
import com.gaos.users.enums.UserRole;
import com.gaos.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            createUsers();
        }
    }

    private void createUsers() {

        User admin = new User();
        admin.setLogin("admin");
        admin.setPassword(passwordEncoder.encode("123qwe!@#"));
        admin.setRole(UserRole.ADMIN);
        userRepository.save(admin);

        User user = new User();
        user.setLogin("user");
        user.setPassword(passwordEncoder.encode("123qwe123"));
        user.setRole(UserRole.USER);
        userRepository.save(user);

        System.out.println("Users Created!");
    }
}
