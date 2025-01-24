package com.gaos.users.controllers;

import com.gaos.users.entities.Email;
import com.gaos.users.entities.Email;
import com.gaos.users.services.EmailService;
import com.gaos.users.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService service;

    @GetMapping
    public List<Email> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> findById(@PathVariable Long id) {
        Optional<Email> email = service.findById(id);
        return email.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Email> save(@RequestBody Email email) {
        Email newEmail = service.save(email);
        return ResponseEntity.ok(newEmail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
