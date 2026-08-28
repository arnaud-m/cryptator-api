/*
 * This file is part of cryptator-api, https://github.com/arnaud-m/cryptator-api
 *
 * Copyright (c) 2026-2026, Université Côte d'Azur. All rights reserved.
 *
 * Licensed under the BSD 3-clause license.
 * See LICENSE file in the project root for full license information.
 */
package cryptator.api.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import cryptator.openapi.model.CryptarithmResults;
import cryptator.openapi.model.SolveRequest;

class CryptatorServiceTest {

    @Test
    void solveEmptyResults() {
        CryptatorService cryptatorService = new CryptatorService();
        SolveRequest request = new SolveRequest();

        request.addEquationsItem("SEND + MORE = MONEY");
        CryptarithmResults result = cryptatorService.solve(request);

        assertNotNull(result, "Result must not be null");
        boolean isEmpty = (result.getCryptarithms() == null) || result.getCryptarithms().isEmpty();
        assertTrue(isEmpty, "Result is expected to be empty");
    }

    @Test
    void solveEmptyResultsJson() throws IOException {
        CryptatorService cryptatorService2 = new CryptatorService();
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/solve-valid-examples.json");

        assertNotNull(inputStream, "JSON file not found");

        SolveRequest request2 = objectMapper.readValue(inputStream, SolveRequest.class);
        CryptarithmResults result2 = cryptatorService2.solve(request2);

        assertNotNull(result2, "Result must not be null");
        boolean isEmpty2 = (result2.getCryptarithms() == null) || result2.getCryptarithms().isEmpty();
        assertTrue(isEmpty2, "Result is expected to be empty");
    }
}