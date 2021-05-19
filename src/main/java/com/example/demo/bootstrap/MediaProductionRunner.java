package com.example.demo.bootstrap;

import com.example.demo.domain.*;
import com.example.demo.service.ActorService;
import com.example.demo.service.MediaProductionService;
import com.example.demo.service.ProductionCrewMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("initiator")
@RequiredArgsConstructor
public class MediaProductionRunner implements CommandLineRunner {

    private final ActorService actorService;
    private final ProductionCrewMemberService productionCrewMemberService;
    private final MediaProductionService mediaProductionService;

    @Override
    public void run(String... args) {

        MediaProduction mp = MediaProduction.builder()
                .name("Matrix III")
                .plotSummary("Plot Summary")
                .mediaProductionCategory(MediaProductionCategory.FILM)
                .rating(BigDecimal.valueOf(90.0))
                .build();

        mediaProductionService.save(mp);

        mp = MediaProduction.builder()
                .name("Friends I")
                .plotSummary("Plot Summary")
                .mediaProductionCategory(MediaProductionCategory.TVSHOW)
                .rating(BigDecimal.valueOf(90.0))
                .build();

        mediaProductionService.save(mp);

        List<ProductionCrewMember> productionCrewMembers = List.of(
                ProductionCrewMember.builder().firstName("Larry").lastName("Wachowski")
                        .role(ProductionCrewMemberRole.DIRECTOR).mediaProduction(mediaProductionService.findById(Long.valueOf(1)))
                        .build()
                ,
                ProductionCrewMember.builder().firstName("Lilly").lastName("Wachowski")
                        .role(ProductionCrewMemberRole.DIRECTOR).mediaProduction(mediaProductionService.findById(Long.valueOf(1)))
                        .build(),
                ProductionCrewMember.builder().firstName("Joel").lastName("Silver")
                        .role(ProductionCrewMemberRole.PRODUCER).mediaProduction(mediaProductionService.findById(Long.valueOf(1)))
                        .build());

        productionCrewMemberService.saveAll(productionCrewMembers);

        List<Actor> actors = List.of(
                Actor.builder().firstName("Keanu").lastName("Reeves").genre("M").character("Neo").mediaProduction(mediaProductionService.findById(Long.valueOf(1))).build(),
                Actor.builder().firstName("Laurence").lastName("Fishburne").genre("M").character("Morpheus").mediaProduction(mediaProductionService.findById(Long.valueOf(1))).build(),
                Actor.builder().firstName("Carrie-Anne").lastName("Moss").genre("F").character("Trinity").mediaProduction(mediaProductionService.findById(Long.valueOf(1))).build(),
                Actor.builder().firstName("Jennifer").lastName("Aniston").genre("F").character("Rachel Green").mediaProduction(mediaProductionService.findById(Long.valueOf(2))).build(),
                Actor.builder().firstName("David").lastName("Schwimmer").genre("M").character("Ross Geller").mediaProduction(mediaProductionService.findById(Long.valueOf(2))).build()
        );
        actorService.saveAll(actors);


    }
}
