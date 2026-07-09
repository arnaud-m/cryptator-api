/*
 * This file is part of cryptator-api, https://github.com/arnaud-m/cryptator-api
 *
 * Copyright (c) 2026-2026, Université Côte d'Azur. All rights reserved.
 *
 * Licensed under the BSD 3-clause license.
 * See LICENSE file in the project root for full license information.
 */
package cryptator.api.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cryptator.openapi.model.CryptarithmResults;
import cryptator.openapi.model.SolveRequest;

@Service
public class SolveService {

    private final Executor solveExecutor;
    private final CryptatorService cryptatorService;

    public SolveService(@Qualifier("solveExecutor") Executor solveExecutor,
                        CryptatorService cryptatorService) {
        this.solveExecutor = solveExecutor;
        this.cryptatorService = cryptatorService;
    }

    public CompletableFuture<CryptarithmResults> solve(SolveRequest request) {

        return CompletableFuture.supplyAsync(() -> 
            cryptatorService.solve(request),
            solveExecutor
        );
    }
}