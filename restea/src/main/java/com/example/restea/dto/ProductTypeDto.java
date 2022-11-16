package com.example.restea.dto;

import com.example.restea.model.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductTypeDto {
    private Long id;
    private String name;

    public ProductTypeDto(Type type) {
        this.id = type.getId();
        this.name = type.getName();
    }

    public Type toProductType(){
        Type type = new Type();
        type.setId(this.id);
        type.setName(this.name);
        return type;
    }
}
