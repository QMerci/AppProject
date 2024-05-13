package com.leadlink.CRM.controller;


import com.leadlink.CRM.model.ContactModel;
import com.leadlink.CRM.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;


    public ContactController(ContactService contactService) {
        this.contactService = contactService;

    }

    @GetMapping
    public String getContactPage(Model model){
        List<ContactModel> contacts = contactService.getAllContacts();
        model.addAttribute("userContact", contacts);
        model.addAttribute("pageName", "Adresář");
        return "contact";
    }

    @GetMapping("/create")
    public String getCreateContactPage(Model model){
        model.addAttribute("newContact", new ContactModel());
        model.addAttribute("pageName", "Adresář - přidat kontakt");
        return "createContact";
    }


    @PostMapping("/create_contact")
    public String createContact(@ModelAttribute ContactModel contact){
        contactService.create(contact);
        return "redirect:/contacts";
    }



    @GetMapping("/edit/{mail}")
    public String getEditContactPage(Model model, @PathVariable String mail){
        ContactModel byMail = contactService.findByEmailAndDelete(mail);
        model.addAttribute("contactToEdit", byMail);
        model.addAttribute("pageName", "Adresář - upravit kontakt");
        return "editContact";
    }

    @PostMapping("/editContact")
    public String editContact(@ModelAttribute ContactModel contact){
        contactService.edit(contact);
        return "redirect:/contacts";

    }

    @GetMapping("/delete/{mail}")
    public String delete(@PathVariable String mail){
        contactService.delete(mail);
        return "redirect:/contacts";
    }



}
