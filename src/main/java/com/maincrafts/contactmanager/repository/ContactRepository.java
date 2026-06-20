package com.maincrafts.contactmanager.repository;

import com.maincrafts.contactmanager.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByNameContaining(String name);
}