package com.rezk.publisher.repository;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "publications")
public class PublicationEntity {

    @MongoId
    private String id;
    private String title;
    private String imageUrl;
    private String text;
}
