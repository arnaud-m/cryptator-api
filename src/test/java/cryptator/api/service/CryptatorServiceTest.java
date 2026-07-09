package cryptator.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cryptator.openapi.model.CryptarithmResults;
import cryptator.openapi.model.SolveRequest;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

public class CryptatorServiceTest {

    @Test
    public void solveEmptyResults() {
        CryptatorService cryptatorService = new CryptatorService();
        SolveRequest request = new SolveRequest();

        request.addEquationsItem("SEND + MORE = MONEY");
        CryptarithmResults result = cryptatorService.solve(request);

        assertNotNull("Le résultat ne doit pas être null", result);
        boolean isEmpty = (result.getCryptarithms() == null) || result.getCryptarithms().isEmpty();
        assertTrue("Le résultat est censé être vide", isEmpty);
    }

    @Test
    public void solveEmptyResultsJson() throws IOException {
        CryptatorService cryptatorService2 = new CryptatorService();
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/solve-valid-examples.json");

        assertNotNull("JSON introuvable", inputStream);

        SolveRequest request2 = objectMapper.readValue(inputStream, SolveRequest.class);
        CryptarithmResults result2 = cryptatorService2.solve(request2);

        assertNotNull("Le résultat ne doit pas être null", result2);
        boolean isEmpty2 = (result2.getCryptarithms() == null) || result2.getCryptarithms().isEmpty();
        assertTrue("Le résultat est censé être vide", isEmpty2);
    }
}