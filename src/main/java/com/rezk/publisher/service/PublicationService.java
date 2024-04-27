package com.rezk.publisher.service;

import com.rezk.publisher.client.CommentClient;
import com.rezk.publisher.domain.Comment;
import com.rezk.publisher.domain.Publication;
import com.rezk.publisher.exceptions.FallbackException;
import com.rezk.publisher.mapper.PublicationMapper;
import com.rezk.publisher.repository.PublicationRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private PublicationMapper publicationMapper;

    @Autowired
    private CommentService commentService;

    public void insert(Publication publication) {
        final var publicationEntity = publicationMapper.toPublicationEntity(publication);
        publicationRepository.save(publicationEntity);
    }

    public List<Publication> findAll() {
        var publications = publicationRepository.findAll();
        return publications.stream().map(publicationMapper::toPublication).toList();
    }

    public Publication findById(String id) {
        Publication publication = publicationRepository.findById(id).map(publicationMapper::toPublication).orElseThrow(RuntimeException::new);
        List<Comment> comments = commentService.getComments(id);
        publication.setComments(comments);
        return publication;
    }


}
