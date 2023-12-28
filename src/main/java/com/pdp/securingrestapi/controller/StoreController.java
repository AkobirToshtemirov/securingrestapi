//package com.pdp.securingrestapi.controller;
//
//import com.pdp.securingrestapi.entity.Store;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(value = "/store/*")
//public class StoreController {
//
//    @PreAuthorize("hasRole('USER')")
//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    public ResponseEntity<Store> create(@Valid @RequestBody Store entity) {
//        return new ResponseEntity<>(entity, HttpStatus.CREATED);
//    }
//
//    @PreAuthorize("hasRole('USER')")
//    @RequestMapping(value = "update", method = RequestMethod.PUT)
//    public ResponseEntity<Store> update(@Valid @RequestBody Store entity) {
//        return new ResponseEntity<>(entity, HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasRole('USER')")
//    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<String> delete(@PathVariable Long id) {
//        return new ResponseEntity<>("Successfully Deleted - Store", HttpStatus.NO_CONTENT);
//    }
//
//    @PreAuthorize("hasRole('USER')")
//    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Store> get(@PathVariable Long id) {
//        return new ResponseEntity<>(new Store(id, "Tets Store Name", "Test Store Description"), HttpStatus.OK);
//    }
//}
