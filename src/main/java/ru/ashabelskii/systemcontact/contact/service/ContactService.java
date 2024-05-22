package ru.ashabelskii.systemcontact.contact.service;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ashabelskii.systemcontact.contact.dto.ContactDto;
import ru.ashabelskii.systemcontact.contact.dto.CreateContactRequest;
import ru.ashabelskii.systemcontact.contact.dto.CreateContactResponse;
import ru.ashabelskii.systemcontact.contact.dto.UpdateContactRequest;
import ru.ashabelskii.systemcontact.core.contact.repo.ContractRepo;

import javax.annotation.Nonnull;


@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContractRepo contractRepo;

    @Nonnull
    public Mono<CreateContactResponse> createContact(@Nonnull Mono<CreateContactRequest> createContactRequest) {
        return createContactRequest
                .map(ContractMapper::toEntity)
                .flatMap(contractRepo::insert)
                .map(contactEntity -> new CreateContactResponse(contactEntity.getId()));
    }

    @Nonnull
    public Mono<ContactDto> getById(@Nonnull ObjectId id) {
        return contractRepo.findById(id)
                .map(ContractMapper::toDto);
    }

    @Nonnull
    public Flux<ContactDto> getAll() {
        return contractRepo.findAll()
                .map(ContractMapper::toDto);
    }

    public Mono<Void> update(
            @Nonnull ObjectId id,
            @Nonnull UpdateContactRequest updateContactRequest
    ) {
        return contractRepo.findById(id)
                .map(it -> ContractMapper.toEntity(updateContactRequest, it))
                .flatMap(contractRepo::save)
                .then();
    }

    public Mono<Void> delete(@Nonnull ObjectId id) {
        return contractRepo.deleteById(id)
                .then();
    }

}
