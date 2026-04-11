/*
 * This file is part of cryptator-api, https://github.com/arnaud-m/cryptator-api
 *
 * Copyright (c) 2026-2026, Université Côte d'Azur. All rights reserved.
 *
 * Licensed under the BSD 3-clause license.
 * See LICENSE file in the project root for full license information.
 */
package cryptator.api.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ExecutorConfig {

	  @Bean(name = "solveExecutor")
	    public Executor solveExecutor() {

	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

	        executor.setCorePoolSize(4);      
	        executor.setMaxPoolSize(8);       
	        executor.setQueueCapacity(100);   

	        executor.setThreadNamePrefix("solve-");
	        executor.initialize();

	        return executor;
	    }
}
