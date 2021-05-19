package com.example.demo.service;

import com.example.demo.domain.MediaProduction;
import com.example.demo.domain.ProductionCrewMember;
import com.example.demo.repository.MediaProductionRepository;
import com.example.demo.repository.ProductionCrewMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductionCrewMemberServiceImpl extends AbstractServiceImpl<ProductionCrewMember> implements ProductionCrewMemberService    {

    private final ProductionCrewMemberRepository productionCrewMemberRepository;

    @Override
    public JpaRepository<ProductionCrewMember, Long> getRepository() {
        return productionCrewMemberRepository;
    }

}
