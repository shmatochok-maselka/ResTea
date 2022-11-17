package com.example.restea.dto;

import com.example.restea.model.Flavor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlavorDto {
    Long id;
    private String name;

    public FlavorDto(Flavor flavor) {
        this.id = flavor.getId();
        this.name = flavor.getName();
    }

    public Flavor toProductFlavor(){
        Flavor flavor = new Flavor();
        flavor.setId(this.id);
        flavor.setName(this.name);
        return flavor;
    }
}
