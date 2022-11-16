package com.example.restea.dto;

import com.example.restea.model.Origin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductOriginDto {
    private Long id;
    private String name;

    public ProductOriginDto(Origin origin) {
        this.id = origin.getId();
        this.name = origin.getName();
    }

    public Origin toProductOrigin(){
        Origin origin = new Origin();
        origin.setId(this.id);
        origin.setName(this.name);
        return origin;
    }
}
