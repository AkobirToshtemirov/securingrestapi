package com.pdp.securingrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request body for token generation")
public record TokenRequest(
        @Schema(description = "Username for authentication", required = true) String username,
        @Schema(description = "Password for authentication", required = true) String password
) {
}
