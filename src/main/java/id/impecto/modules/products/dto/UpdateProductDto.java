package id.impecto.modules.products.dto;

import lombok.Data;

@Data
public class UpdateProductDto {
    private String code;
    private String name;
    private Float price;
    private Long categoryId;
}
