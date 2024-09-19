package id.impecto.modules.category.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateCategoryDto {
    
    @NotEmpty(message = "Name is required")
    private String name;
}
