package com.leadlink.CRM.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class UserModel {
    @Id
    private String id;
    private String username;
    private String password;
    private UserRole role;
    private String firstName;
    private String lastName;
}
