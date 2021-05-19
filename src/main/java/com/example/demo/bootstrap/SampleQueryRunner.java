package com.example.demo.bootstrap;

import com.example.demo.base.AbstractLogEntity;
import com.example.demo.domain.MediaProduction;
import com.example.demo.service.ActorService;
import com.example.demo.service.MediaProductionService;
import com.example.demo.service.ProductionCrewMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("getdata")
public class SampleQueryRunner extends AbstractLogEntity implements CommandLineRunner {

	private final ActorService actorService;
	private final ProductionCrewMemberService productionCrewMemberService;
	private final MediaProductionService mediaProductionService;

	@Override
	public void run(String... args) {
		logger.info("Getting first order");
		MediaProduction mp = mediaProductionService.findById(1L);
		logger.info("{} with {} items.", mp, 2);

		logger.info("------------------------------------------------------");

	}
}
