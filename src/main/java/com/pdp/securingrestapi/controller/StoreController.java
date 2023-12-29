package com.pdp.securingrestapi.controller;

import com.pdp.securingrestapi.entity.Store;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/store/*")
public class StoreController {

    @PreAuthorize("hasRole('USER')")
    @PostMapping(value = "create")
    @Operation(summary = "Create New Store", description = "Creates a new store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Created",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Store.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))})
    })
    public ResponseEntity<Store> create(@Valid @RequestBody Store entity) {
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping(value = "update")
    @Operation(summary = "Update Store", description = "Updates an existing store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Updated",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Store.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))})
    })
    public ResponseEntity<Store> update(@Valid @RequestBody Store entity) {
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(value = "delete/{id}")
    @Operation(summary = "Delete Store", description = "Deletes an existing store by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully Deleted - Store"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))})
    })
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>("Successfully Deleted - Store", HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "get/{id}")
    @Operation(summary = "Get Store by ID", description = "Retrieves a store by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Store.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))})
    })
    public ResponseEntity<Store> get(@PathVariable Long id) {
        return new ResponseEntity<>(new Store(id, "Test Store Name", "Test Store Description"), HttpStatus.OK);
    }
}
