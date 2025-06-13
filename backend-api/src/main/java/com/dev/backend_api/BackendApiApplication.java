package com.dev.backend_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import com.dev.backend_api.domain.RequestContext;
import com.dev.backend_api.entity.RoleEntity;
import com.dev.backend_api.enumeration.Authority;
import com.dev.backend_api.repository.RoleRepository;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class BackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
		return args -> {
			RequestContext.setUserId("");

			if (roleRepository.findByNameIgnoreCase(Authority.USER.name()).isEmpty()) {
				var userRole = new RoleEntity();
				userRole.setName(Authority.USER.name());
				userRole.setAuthorities(Authority.USER);
				roleRepository.save(userRole);
			}

			if (roleRepository.findByNameIgnoreCase(Authority.USER.name()).isEmpty()) {
				var adminRole = new RoleEntity();
				adminRole.setName(Authority.ADMIN.name());
				adminRole.setAuthorities(Authority.ADMIN);
				roleRepository.save(adminRole);
			}

			RequestContext.start();
		};
	}

	
}
