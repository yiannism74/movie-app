package com.example.demo.repository;

import com.example.demo.domain.Actor;
import com.example.demo.domain.MediaProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorRepository extends JpaRepository<Actor,Long> {


}
