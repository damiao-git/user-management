package com.gaos.users.controllers;

import com.gaos.users.entities.Address;
import com.gaos.users.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresssdsdsd")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public List<Address> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        Optional<Address> address = service.findById(id);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody Address address) {
        Address newAddress = service.save(address);
        return ResponseEntity.ok(newAddress);
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
