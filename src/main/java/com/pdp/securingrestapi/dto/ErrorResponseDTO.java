package com.pdp.securingrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Schema(description = "DTO for representing error responses")
public class ErrorResponseDTO {

    @Schema(description = "Path where the error occurred")
    private String errorPath;

    @Schema(description = "Error code")
    private Integer errorCode;

    @Schema(description = "Body containing error details")
    private Object errorBody;

    @Schema(description = "Timestamp when the error occurred")
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
