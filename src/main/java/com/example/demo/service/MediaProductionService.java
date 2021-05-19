package com.example.demo.service;

import com.example.demo.domain.MediaProduction;

public interface MediaProductionService extends BaseService<MediaProduction,Long>{
    MediaProduction findLazy(Long id);
    MediaProduction findMediaProductionByActors(String firstName,String lastName);

}
