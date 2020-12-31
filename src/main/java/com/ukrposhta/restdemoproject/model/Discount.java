package com.ukrposhta.restdemoproject.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "discount")
    @ToString.Exclude
    private Product product;
    @Column(columnDefinition = "double precision default 0")
    private Float discount;

}
