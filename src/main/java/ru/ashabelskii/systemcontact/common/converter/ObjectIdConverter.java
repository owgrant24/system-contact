package ru.ashabelskii.systemcontact.common.converter;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import javax.annotation.Nullable;


public final class ObjectIdConverter implements Converter<String, ObjectId> {

    @Nullable
    @Override
    public ObjectId convert(@Nullable String source) {
        return StringUtils.hasText(source)
                ? new ObjectId(source)
                : null;
    }

}
