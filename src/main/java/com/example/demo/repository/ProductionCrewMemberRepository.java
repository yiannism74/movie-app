package com.example.demo.repository;

import com.example.demo.domain.MediaProduction;
import com.example.demo.domain.ProductionCrewMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionCrewMemberRepository extends JpaRepository<ProductionCrewMember,Long> {
}
