package com.pdp.securingrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Schema(description = "DTO for representing application errors")
public class AppErrorDto {

    @Schema(description = "Error message")
    private final String errorMessage;

    @Schema(description = "Path where the error occurred")
    private final String errorPath;

    @Schema(description = "Error code")
    private final Integer errorCode;

    @Schema(description = "Timestamp when the error occurred")
    private final LocalDateTime timestamp;

    public AppErrorDto(String errorMessage, String errorPath, Integer errorCode) {
        this.errorMessage = errorMessage;
        this.errorPath = errorPath;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now();
    }
}
