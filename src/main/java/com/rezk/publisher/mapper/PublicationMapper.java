package com.rezk.publisher.mapper;

import com.rezk.publisher.controller.request.PublicationRequest;
import com.rezk.publisher.domain.Publication;
import com.rezk.publisher.repository.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);

    Publication toPublication(PublicationEntity publicationEntity);

    Publication toPublication(PublicationRequest publicationRequest);

}
