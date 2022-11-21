package com.jdc04.demo2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc04.demo2.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
