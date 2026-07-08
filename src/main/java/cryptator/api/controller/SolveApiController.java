/*
 * This file is part of cryptator-api, https://github.com/arnaud-m/cryptator-api
 *
 * Copyright (c) 2026-2026, Université Côte d'Azur. All rights reserved.
 *
 * Licensed under the BSD 3-clause license.
 * See LICENSE file in the project root for full license information.
 */
package cryptator.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cryptator.api.service.SolveService;
import cryptator.openapi.api.SolveApi;
import cryptator.openapi.model.CryptarithmResults;
import cryptator.openapi.model.SolveRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@RestController
public class SolveApiController implements SolveApi {

	private final SolveService solveService;

	public SolveApiController(SolveService solveService) {
		this.solveService = solveService;
	}

	@Override
	public ResponseEntity<CryptarithmResults> solve(@Valid SolveRequest solveRequest,
			@Min(2) @Max(36) @Valid Integer base) {
		CryptarithmResults result = solveService.solve(solveRequest).join();
		return ResponseEntity.ok(result);
	}

}