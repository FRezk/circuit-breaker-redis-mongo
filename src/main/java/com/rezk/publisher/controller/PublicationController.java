package com.rezk.publisher.controller;

import com.rezk.publisher.controller.request.PublicationRequest;
import com.rezk.publisher.domain.Publication;
import com.rezk.publisher.mapper.PublicationMapper;
import com.rezk.publisher.service.PublicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publication")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationMapper publicationMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody PublicationRequest publicationRequest) {
        var publication = publicationMapper.toPublication(publicationRequest);
        publicationService.insert(publication);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publication> findAll() {
        return publicationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publication findById(@PathVariable("id") final String id) {
        return publicationService.findById(id);
    }



}
