package com.deccanherald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.deccanherald.entity.Article;
import com.deccanherald.entity.IssueReport;
import com.deccanherald.entity.SourceFirstCode;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories
public class SourcefirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourcefirstApplication.class, args);
	}
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer()
	{
		return new RepositoryRestConfigurerAdapter() {
			
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.exposeIdsFor(SourceFirstCode.class, Article.class, IssueReport.class);
			}
		};
	}
}
