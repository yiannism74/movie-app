package com.example.demo.service;

import com.example.demo.domain.Actor;
import com.example.demo.domain.MediaProduction;
import com.example.demo.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends AbstractServiceImpl<Actor> implements ActorService    {

    private final ActorRepository actorRepository;

    @Override
    public JpaRepository<Actor, Long> getRepository() {
        return actorRepository;
    }

}
