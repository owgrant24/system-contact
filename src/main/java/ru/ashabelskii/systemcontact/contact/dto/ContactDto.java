package ru.ashabelskii.systemcontact.contact.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.types.ObjectId;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


public record ContactDto(
        @Schema(description = "Идентификатор контакта", requiredMode = REQUIRED)
        ObjectId id,
        @Schema(description = "Фамилия", example = "Петров", requiredMode = REQUIRED)
        String lastName,
        @Schema(description = "Имя", example = "Сергей", requiredMode = REQUIRED)
        String firstName,
        @Schema(description = "Отчество", example = "Иванович", requiredMode = NOT_REQUIRED)
        String middleName,
        @Schema(description = "Телефон", example = "+79046195555", requiredMode = NOT_REQUIRED)
        String phone,
        @Schema(description = "Дополнительная информация", example = "Дополнительная информация", requiredMode = NOT_REQUIRED)
        String additionally
) {

}
