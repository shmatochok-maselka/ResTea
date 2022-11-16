package com.example.restea.dto;

import com.example.restea.model.Property;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyDto {
    private Long id;
    private String name;

    public PropertyDto(Property property) {
        this.id = property.getId();
        this.name = property.getName();
    }

    public Property toProductProperty(){
        Property property = new Property();
        property.setId(this.id);
        property.setName(this.name);
        return property;
    }
}
