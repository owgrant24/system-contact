package ru.ashabelskii.systemcontact.core.contact.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.ashabelskii.systemcontact.core.contact.entity.ContactEntity;


public interface ContractRepo extends ReactiveMongoRepository<ContactEntity, ObjectId> {

}
