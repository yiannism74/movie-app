package com.example.demo.service;

import com.example.demo.domain.MediaProduction;
import com.example.demo.repository.MediaProductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaProductionServiceImpl extends AbstractServiceImpl<MediaProduction> implements MediaProductionService    {

    private final MediaProductionRepository mediaProductionRepository;

    @Override
    public JpaRepository<MediaProduction, Long> getRepository() {
        return mediaProductionRepository;
    }

    @Override
    public MediaProduction findLazy(Long id) {
        logger.info("Executed findLazy by id:{}",id);
        return mediaProductionRepository.findLazy(id);
   }
    @Override
    public MediaProduction findMediaProductionByActors(String firstName,String lastName) {
        logger.info("Executed findMediaProductionByActors firstName:{},lastName{}",firstName,lastName);
        return mediaProductionRepository.findMediaProductionByActors( firstName, lastName);
    }

}
