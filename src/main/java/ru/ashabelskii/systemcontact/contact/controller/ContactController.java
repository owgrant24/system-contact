package ru.ashabelskii.systemcontact.contact.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ashabelskii.systemcontact.contact.dto.ContactDto;
import ru.ashabelskii.systemcontact.contact.dto.CreateContactRequest;
import ru.ashabelskii.systemcontact.contact.dto.CreateContactResponse;
import ru.ashabelskii.systemcontact.contact.dto.UpdateContactRequest;
import ru.ashabelskii.systemcontact.contact.service.ContactService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contacts")
@Tag(name = "Contacts")
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public Mono<CreateContactResponse> create(
            @NotNull @Valid @RequestBody Mono<CreateContactRequest> createContactRequest
    ) {
        return contactService.createContact(createContactRequest);
    }

    @GetMapping("/{id}")
    public Mono<ContactDto> getById(@NotNull @PathVariable ObjectId id) {
        return contactService.getById(id);
    }

    @GetMapping
    public Flux<ContactDto> getAll() {
        return contactService.getAll();
    }

    @PutMapping("/{id}")
    public Mono<Void> update(
            @NotNull @PathVariable ObjectId id,
            @NotNull @Valid @RequestBody UpdateContactRequest updateNoteRequest
    ) {
        return contactService.update(id, updateNoteRequest);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@NotNull @PathVariable ObjectId id) {
        return contactService.delete(id);
    }

}