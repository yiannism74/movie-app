package com.example.demo.controller;

import com.example.demo.domain.MediaProduction;
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
@RequestMapping("/")
public class MediaProductionController extends AbstractController<MediaProduction> {
    private final MediaProductionService mediaProductionService;

    @Override
    public BaseService<MediaProduction, Long> getBaseService() {
        return mediaProductionService;
    }

    @RequestMapping("/mediabyid")
    @GetMapping(params = {"mediaid"})
    public ResponseEntity<ApiResponse<MediaProduction>> findMediaProductionDetails(Long mediaid) {

        final MediaProduction results = mediaProductionService.findLazy(mediaid);

        return ResponseEntity.ok(ApiResponse.<MediaProduction>builder().data(results).build());
    }
    @RequestMapping("/mediabyactor")
    @GetMapping(params = {"actorname,actorlastname"})
    public ResponseEntity<ApiResponse<MediaProduction>> findMediaProductionByActors(String actorname, String actorlastname) {

        logger.trace("Controller resolves to findMediaProductionByActors with params actorname={},actorlastname={}",actorname,actorlastname);
        final MediaProduction results = mediaProductionService.findMediaProductionByActors(actorname,actorlastname);

        return ResponseEntity.ok(ApiResponse.<MediaProduction>builder().data(results).build());
    }
}
