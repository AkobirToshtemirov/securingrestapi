package com.pdp.securingrestapi.entity;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springdoc.core.annotations.ParameterObject;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Schema(name = "Store Entity", description = "Store Entity Description")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @NotNull
    @Parameter(description = "Store Identifier", required = true)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Parameter(description = "Store Name", required = true)
    private String name;

    @NotBlank
    @Parameter(description = "Store Description", required = false)
    private String description;
}
