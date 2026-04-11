/*
 * This file is part of cryptator-api, https://github.com/arnaud-m/cryptator-api
 *
 * Copyright (c) 2026-2026, Université Côte d'Azur. All rights reserved.
 *
 * Licensed under the BSD 3-clause license.
 * See LICENSE file in the project root for full license information.
 */
package cryptator.api.service;

import org.springframework.stereotype.Service;

import cryptator.openapi.model.CryptarithmResults;
import cryptator.openapi.model.SolvePostRequest;

@Service
public class CryptatorService {

	 public CryptarithmResults solve(SolvePostRequest request) {

	        // TODO: appel réel vers ton module cryptator (ANTLR)
	        CryptarithmResults result = new CryptarithmResults();

	        return result;
	    }
}
