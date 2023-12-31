//package com.pdp.securingrestapi.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import lombok.*;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//public class Item {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank
//    private String name;
//
//    @NotBlank
//    private String description;
//
//    @Min(1)
//    private Double price;
//    private String path;
//}
