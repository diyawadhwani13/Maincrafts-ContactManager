package com.maincrafts.contactmanager.controller;

import com.maincrafts.contactmanager.entity.Contact;
import com.maincrafts.contactmanager.repository.ContactRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactController {

    private final ContactRepository repository;

    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/contact")
    public Contact saveContact(
            @Valid @RequestBody Contact contact) {

        return repository.save(contact);
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {

        return repository.findAll();
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {

        repository.deleteById(id);
    }

    @GetMapping("/search")
    public List<Contact> searchContacts(
            @RequestParam String name) {

        return repository.findByNameContaining(name);
    }
}