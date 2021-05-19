package com.example.demo.repository;

import com.example.demo.domain.MediaProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MediaProductionRepository extends JpaRepository<MediaProduction,Long> {

    @Query("select o from MediaProduction o left join fetch o.actors a left join fetch o.productionCrewMembers p where o.id = ?1")
    MediaProduction findLazy(Long id);

    //@Query("select o from MediaProduction o join fetch o.actors a join fetch o.productionCrewMembers p where a.firstName like ?1% and  a.lastName like ?2%")
    @Query(value = "SELECT * FROM MEDIA_PRODUCTION MP LEFT JOIN ACTORS AC ON MP.ID = AC.MEDIAPRODUCTION_ID LEFT JOIN PRODUCTION_CREW_MENBERS PM ON PM.MEDIAPRODUCTION_ID = MP.ID \n" +
            "WHERE AC.FIRSTNAME LIKE ?1% AND AC.LASTNAME LIKE ?2%",nativeQuery = true)
    MediaProduction findMediaProductionByActors(String firstName,String lastName);

}
