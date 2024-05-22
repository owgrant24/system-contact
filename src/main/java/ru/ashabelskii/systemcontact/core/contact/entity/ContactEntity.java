package ru.ashabelskii.systemcontact.core.contact.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.time.Instant;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

    @BsonId
    private ObjectId id;
    private Instant createdAt;
    private Instant modifiedAt;
    private String lastName;
    private String firstName;
    private String middleName;
    private String phone;
    private String additionally;

}
