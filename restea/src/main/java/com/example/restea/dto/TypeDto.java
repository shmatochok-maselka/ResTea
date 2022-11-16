package com.example.restea.dto;

import com.example.restea.model.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeDto {
    private Long id;
    private String name;

    public TypeDto(Type type) {
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
