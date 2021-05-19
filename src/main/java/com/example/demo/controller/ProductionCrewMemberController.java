package com.example.demo.controller;

import com.example.demo.domain.Actor;
import com.example.demo.domain.ProductionCrewMember;
import com.example.demo.service.BaseService;
import com.example.demo.service.ProductionCrewMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productioncrew")
public class ProductionCrewMemberController extends AbstractController<ProductionCrewMember> {

    private final ProductionCrewMemberService productionCrewMemberService;
    @Override
    public BaseService<ProductionCrewMember, Long> getBaseService() {
        return productionCrewMemberService;
    }
}
