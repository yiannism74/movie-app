package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTION_CREW_MENBERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCTION_CREW_MENBERS_SEQ", initialValue = 1, allocationSize = 1)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductionCrewMember extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private ProductionCrewMemberRole role;

    @JsonBackReference("mediaProduction")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private  MediaProduction mediaProduction;
}
