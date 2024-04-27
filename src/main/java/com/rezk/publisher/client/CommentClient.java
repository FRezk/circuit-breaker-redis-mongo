package com.rezk.publisher.client;

import com.rezk.publisher.domain.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CommentClient", url = "${client.comment.url}")
public interface CommentClient {

    @GetMapping("/comment/{publicationId}")
    List<Comment> getComments(@PathVariable("publicationId") String publicationId);

}
