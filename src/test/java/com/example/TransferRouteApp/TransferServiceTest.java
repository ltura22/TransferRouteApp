package com.example.TransferRouteApp;

import com.example.TransferRouteApp.model.SelectedTransfer;
import com.example.TransferRouteApp.model.Transfer;
import com.example.TransferRouteApp.model.TransferInput;
import com.example.TransferRouteApp.service.TransferService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransferServiceTest {

    @Test
    void testGetMaximumCostSmall(){
        TransferService transferService = new TransferService();

        List<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(8, 1));
        transfers.add(new Transfer(4, 2));
        transfers.add(new Transfer(0, 3));
        transfers.add(new Transfer(5, 2));
        transfers.add(new Transfer(3, 2));

        TransferInput transferInput = new TransferInput(4, transfers);

        SelectedTransfer result = transferService.getMaximumCost(transferInput);

        assertEquals(13, result.getTotalCost());
        assertEquals(3, result.getTotalWeight());
        assertEquals(2, result.getSelectedTransfers().size());
        assertTrue(result.getSelectedTransfers().contains(new Transfer(5, 2)));
        assertTrue(result.getSelectedTransfers().contains(new Transfer(8, 1)));
    }

    @Test
    void testGetMaximumCostBig(){
        TransferService transferService = new TransferService();

        List<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(86, 1384));
        transfers.add(new Transfer(115, 778));
        transfers.add(new Transfer(135, 1794));
        transfers.add(new Transfer(92, 1387));
        transfers.add(new Transfer(21, 650));
        transfers.add(new Transfer(27, 363));
        transfers.add(new Transfer(59, 691));
        transfers.add(new Transfer(126, 1764));
        transfers.add(new Transfer(26, 541));
        transfers.add(new Transfer(136, 1173));
        transfers.add(new Transfer(168, 1212));
        transfers.add(new Transfer(29, 568));
        transfers.add(new Transfer(130, 1783));
        transfers.add(new Transfer(123, 863));
        transfers.add(new Transfer(135, 68));
        transfers.add(new Transfer(2, 1930));
        transfers.add(new Transfer(58, 23));
        transfers.add(new Transfer(167, 1070));
        transfers.add(new Transfer(56, 1394));
        transfers.add(new Transfer(42, 1012));

        TransferInput transferInput = new TransferInput(2000, transfers);

        SelectedTransfer result = transferService.getMaximumCost(transferInput);

        assertEquals(475, result.getTotalCost());
        assertEquals(1939, result.getTotalWeight());
        assertEquals(4, result.getSelectedTransfers().size());
        assertTrue(result.getSelectedTransfers().contains(new Transfer(135, 68)));
        assertTrue(result.getSelectedTransfers().contains(new Transfer(167, 1070)));
        assertTrue(result.getSelectedTransfers().contains(new Transfer(58, 23)));
        assertTrue(result.getSelectedTransfers().contains(new Transfer(115, 778)));
    }

    @Test
    void testGetMaximumCostEmpty(){
        TransferService transferService = new TransferService();

        List<Transfer> transfers = new ArrayList<>();
        TransferInput transferInput = new TransferInput(4, transfers);

        SelectedTransfer result = transferService.getMaximumCost(transferInput);

        assertEquals(0, result.getTotalCost());
        assertEquals(0, result.getTotalWeight());
        assertEquals(0, result.getSelectedTransfers().size());
    }

    @Test
    void testGetMaximumCostOverWeight(){
        TransferService transferService = new TransferService();

        List<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(8, 3));
        transfers.add(new Transfer(4, 2));
        transfers.add(new Transfer(0, 3));

        SelectedTransfer result = transferService.getMaximumCost(new TransferInput(1, transfers));

        assertEquals(0, result.getTotalCost());
        assertEquals(0, result.getTotalWeight());
        assertEquals(0, result.getSelectedTransfers().size());
    }
}