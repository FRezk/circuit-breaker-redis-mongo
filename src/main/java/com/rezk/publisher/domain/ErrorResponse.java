package com.rezk.publisher.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@NotBlank
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private Long timestamp;
    private Integer status;
    private String message;
    private String path;

}
