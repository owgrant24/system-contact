package ru.ashabelskii.systemcontact.common.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.models.media.StringSchema;
import org.bson.types.ObjectId;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ashabelskii.systemcontact.common.deserializer.ObjectIdJsonDeserializer;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY;


@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder
                .serializerByType(ObjectId.class, new ToStringSerializer())
                .deserializerByType(ObjectId.class, new ObjectIdJsonDeserializer())
                .featuresToDisable(FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY);
    }

    static {
        SpringDocUtils.getConfig().replaceWithSchema(ObjectId.class, new StringSchema());
    }

}
