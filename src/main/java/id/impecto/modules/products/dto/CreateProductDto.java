package id.impecto.modules.products.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProductDto {
    @NotBlank(message = "Name is required")
    private String name;

    private String code;

    @NotNull(message = "Price is required")
    private Float price;

    @NotNull(message = "Category id is required")
    private Long categoryId;
}
