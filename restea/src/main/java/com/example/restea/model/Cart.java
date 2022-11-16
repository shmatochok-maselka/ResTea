package com.example.restea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart implements  java.io.Serializable{
    @EmbeddedId
    private CartId id;

    @Column(name = "weight")
    private int productWeight;

}
