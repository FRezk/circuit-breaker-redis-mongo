package com.rezk.publisher.service;

import com.rezk.publisher.client.CommentClient;
import com.rezk.publisher.domain.Comment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private CommentClient commentClient;

    @Autowired
    private RedisService redisService;

    @CircuitBreaker(name = "comment", fallbackMethod = "getCommentsFallback")
    public List<Comment> getComments(String publicationId) {
        final var comments = commentClient.getComments(publicationId);
        redisService.save(comments, publicationId);
        return comments;
    }

    private List<Comment> getCommentsFallback(String publicationId, Throwable cause) {
        log.warn("[WARN] Fallback with publicationID {}", publicationId);
        return redisService.findById(publicationId);
    }

}
