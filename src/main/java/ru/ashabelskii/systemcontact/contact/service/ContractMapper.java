package ru.ashabelskii.systemcontact.contact.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.ashabelskii.systemcontact.contact.dto.ContactDto;
import ru.ashabelskii.systemcontact.contact.dto.CreateContactRequest;
import ru.ashabelskii.systemcontact.contact.dto.UpdateContactRequest;
import ru.ashabelskii.systemcontact.core.contact.entity.ContactEntity;

import javax.annotation.Nonnull;
import java.time.Instant;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractMapper {

    public static ContactDto toDto(@Nonnull ContactEntity contactEntity) {
        return new ContactDto(
                contactEntity.getId(),
                contactEntity.getLastName(),
                contactEntity.getFirstName(),
                contactEntity.getMiddleName(),
                contactEntity.getPhone(),
                contactEntity.getAdditionally()
        );
    }

    public static ContactEntity toEntity(@Nonnull CreateContactRequest createContactRequest) {
        var contactEntity = new ContactEntity();
        contactEntity.setCreatedAt(Instant.now());
        contactEntity.setModifiedAt(Instant.now());
        contactEntity.setLastName(createContactRequest.lastName());
        contactEntity.setFirstName(createContactRequest.firstName());
        contactEntity.setMiddleName(createContactRequest.middleName());
        contactEntity.setPhone(createContactRequest.phone());
        contactEntity.setAdditionally(createContactRequest.additionally());
        return contactEntity;
    }

    public static ContactEntity toEntity(
            @Nonnull UpdateContactRequest updateContactRequest,
            @Nonnull ContactEntity contactEntity
    ) {
        contactEntity.setModifiedAt(Instant.now());
        contactEntity.setLastName(updateContactRequest.lastName());
        contactEntity.setFirstName(updateContactRequest.firstName());
        contactEntity.setMiddleName(updateContactRequest.middleName());
        contactEntity.setPhone(updateContactRequest.phone());
        contactEntity.setAdditionally(updateContactRequest.additionally());
        return contactEntity;
    }

}
