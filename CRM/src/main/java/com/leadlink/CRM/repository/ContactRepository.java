package com.leadlink.CRM.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.leadlink.CRM.model.ContactModel;

@Repository
public interface ContactRepository extends MongoRepository<ContactModel, String> {

}
