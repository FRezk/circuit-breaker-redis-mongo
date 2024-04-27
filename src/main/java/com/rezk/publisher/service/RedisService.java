package com.rezk.publisher.service;

import com.rezk.publisher.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    private static final String KEY = "Comment";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void save(List<Comment> comments, String publicationId) {
        redisTemplate.opsForHash().put(KEY, publicationId, comments);
    }

    public List<Comment> findById(String publicationId) {
        return (List<Comment>) redisTemplate.opsForHash().get(KEY, publicationId);
    }

}
