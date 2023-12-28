package com.pdp.securingrestapi.controller;

import com.pdp.securingrestapi.entity.Item;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/item/*")
public class ItemController {

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Item> create(@Valid @RequestBody Item item) {
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Item> update(@Valid @RequestBody Item item) {
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>("Successfully Deleted - Item", HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "get/{id}", method = RequestMethod.POST)
    public ResponseEntity<Item> get(@PathVariable Long id) {
        return new ResponseEntity<>(new Item(id, "Test Name", "Test Description", 120.5D, "Test Path...."), HttpStatus.OK);
    }
}
