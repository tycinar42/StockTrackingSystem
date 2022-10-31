package com.tyc.dto.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateProductStockRequestDto {
    @NotNull(message = "Id must not be null")
    private Long productId;
    @NotNull(message = "Brand must not be null")
    private String brand;
    @NotNull(message = "Model must not be null")
    private String model;
    @NotNull(message = "Name must not be null")
    private String name;
    @Builder.Default
    private int piece = 0;
}
