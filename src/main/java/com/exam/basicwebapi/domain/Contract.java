package com.exam.basicwebapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "contract")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="companyId", nullable=false)
    private Company company;

    @ManyToOne
    @JoinColumn(name="countryId", nullable=false)
    private Country country;
}
