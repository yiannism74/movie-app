package com.example.demo.controller;

import com.example.demo.domain.Actor;
import com.example.demo.domain.MediaProduction;
import com.example.demo.service.ActorService;
import com.example.demo.service.BaseService;
import com.example.demo.service.MediaProductionService;
import com.example.demo.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController extends AbstractController<Actor> {

    private final ActorService actorService;
    @Override
    public BaseService<Actor, Long> getBaseService() {
        return actorService;
    }


}
