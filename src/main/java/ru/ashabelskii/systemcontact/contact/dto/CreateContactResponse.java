package ru.ashabelskii.systemcontact.contact.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.types.ObjectId;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


public record CreateContactResponse(
        @Schema(description = "Идентификатор контакта", requiredMode = REQUIRED)
        ObjectId id
) {

}
