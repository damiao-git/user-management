package com.gaos.users.controllers;

import com.gaos.users.dto.AddressDTO;
import com.gaos.users.dto.ClientDTO;
import com.gaos.users.entities.Client;
import com.gaos.users.services.ClientService;
import com.gaos.users.services.ViaCepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping
    public List<Client> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Optional<Client> user = service.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ClientDTO client, BindingResult result) {
        if(!viaCepService.isValidCep(client.getAddress().getCep())){
            return ResponseEntity.badRequest().body("Invalid CEP!");
        }
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        client.getEmails().forEach(email -> email.setClient(client));

        client.getPhones().forEach(phone -> phone.setClient(client));
        Client client1 = service.convertToEntity(client);

        Client newClient = service.save(client1);
        return ResponseEntity.ok(newClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody ClientDTO userUpdated) {
        try {
            Client client = service.update(id, userUpdated);
            return ResponseEntity.ok(client);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
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
