package com.rezk.publisher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends MongoRepository<PublicationEntity, String> {



}
