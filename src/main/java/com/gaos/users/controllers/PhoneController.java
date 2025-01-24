package com.gaos.users.controllers;

import com.gaos.users.entities.Address;
import com.gaos.users.entities.Phone;
import com.gaos.users.services.AddressService;
import com.gaos.users.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {

    @Autowired
    private PhoneService service;

    @GetMapping
    public List<Phone> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> findById(@PathVariable Long id) {
        Optional<Phone> phone = service.findById(id);
        return phone.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Phone> save(@RequestBody Phone phone) {
        Phone newPhone = service.save(phone);
        return ResponseEntity.ok(newPhone);
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
