package com.leadlink.CRM.service;

import com.leadlink.CRM.model.ContactModel;
import com.leadlink.CRM.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;

    public List<ContactModel> getAllContacts() {
        return contactRepository.findAll();
    }

    public ContactModel create(ContactModel contact) {
        return contactRepository.save(contact);
    }

    public ContactModel findByEmailAndDelete(String mail) {
        ContactModel contactModel = contactRepository.findAll().stream()
                .filter(it->it.getMail().equals(mail))
                .findFirst()
                .orElseThrow(IllegalArgumentException:: new );

        contactRepository.delete(contactModel);
        return contactModel;
    }

    public void edit(ContactModel contact) {
        create(contact);
    }

    public void delete(String mail) {
        findByEmailAndDelete(mail);}

}
