package com.leadlink.CRM.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("contact")
public class ContactModel {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private byte[] photo;
    private String position;
    private String mail;
    private int phone;
    private String note;
    private String company;

}
