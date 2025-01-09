package com.example.TransferRouteApp;

import com.example.TransferRouteApp.model.SelectedTransfer;
import com.example.TransferRouteApp.model.Transfer;
import com.example.TransferRouteApp.model.TransferInput;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Meant to be tested with the server running
// Make sure to set correct host and port before running
@SpringBootTest
public class TransferServiceIntegrationTest {

    private String host = "localhost";
    private int port = 8080;

    @Test
    void testGetMaximumCost() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://%s:%d/api/maximum-cost", host, port);

        List<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(8, 1));
        transfers.add(new Transfer(4, 2));
        transfers.add(new Transfer(0, 3));
        transfers.add(new Transfer(5, 2));
        transfers.add(new Transfer(3, 2));
        TransferInput transferInput = new TransferInput(4, transfers);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<TransferInput> request = new HttpEntity<>(transferInput, headers);

        ResponseEntity<SelectedTransfer> response = restTemplate.exchange(url, HttpMethod.POST, request, SelectedTransfer.class);

        SelectedTransfer result = response.getBody();

        assert result != null;
        assertEquals(13, result.getTotalCost());
        assertEquals(3, result.getTotalWeight());
        assertEquals(2, result.getSelectedTransfers().size());
    }
}