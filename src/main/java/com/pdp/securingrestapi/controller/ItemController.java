package com.pdp.securingrestapi.controller;

import com.pdp.securingrestapi.entity.Item;
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
@RequestMapping(value = "/item/*")
public class ItemController {

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "create")
    @Operation(summary = "Create New Item", description = "Creates a new item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Created",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Item.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))})
    })
    public ResponseEntity<Item> create(@Valid @RequestBody Item item) {
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "update")
    @Operation(summary = "Update Item", description = "Updates an existing item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Updated",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Item.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))})
    })
    public ResponseEntity<Item> update(@Valid @RequestBody Item item) {
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "delete/{id}")
    @Operation(summary = "Delete Item", description = "Deletes an existing item by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully Deleted - Item"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))})
    })
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>("Successfully Deleted - Item", HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "get/{id}")
    @Operation(summary = "Get Item by ID", description = "Retrieves an item by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Item.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))})
    })
    public ResponseEntity<Item> get(@PathVariable Long id) {
        return new ResponseEntity<>(new Item(id, "Test Name", "Test Description", 120.5D, "Test Path...."), HttpStatus.OK);
    }
}
