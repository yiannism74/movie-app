package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Delegate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "MEDIA_PRODUCTION")
@SequenceGenerator(name = "idGenerator", sequenceName = "MEDIA_PRODUCTION_SEQ", initialValue = 1, allocationSize = 1)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaProduction extends BaseEntity{

    private interface MyDelegateActor {
        boolean add(Actor actor);

        boolean remove(Actor actor);
    }
    private interface MyDelegateProductionCrewMember {
        boolean add(ProductionCrewMember productionCrewMember);

        boolean remove(ProductionCrewMember productionCrewMember);
    }
    @NotNull
    @Column(nullable = false)
    String name;

    @Enumerated(EnumType.STRING)
    MediaProductionCategory mediaProductionCategory;

    String plotSummary;

    @Column(precision = 5, scale = 2, nullable = false)
    BigDecimal rating;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Delegate(types = MyDelegateActor.class)
    @OneToMany(mappedBy = "mediaProduction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final Set<Actor> actors= new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Delegate(types = MyDelegateProductionCrewMember.class)
    @OneToMany(mappedBy = "mediaProduction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final Set<ProductionCrewMember> productionCrewMembers= new HashSet<>();

}
