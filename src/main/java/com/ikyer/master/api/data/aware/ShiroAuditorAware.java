package com.ikyer.master.api.data.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.ikyer.master.api.data.domain.User;

@Configuration
@EnableJpaAuditing
public class ShiroAuditorAware {

	@Bean
	public AuditorAware<User> auditorProvider() {
		return new AuditorAware<User>() {

			@Override
			public User getCurrentAuditor() {
				return new User(1L);
			}
		};
	}
}
