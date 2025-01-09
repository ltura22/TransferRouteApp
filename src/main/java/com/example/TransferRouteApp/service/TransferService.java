package com.example.TransferRouteApp.service;

import com.example.TransferRouteApp.model.SelectedTransfer;
import com.example.TransferRouteApp.model.Transfer;
import com.example.TransferRouteApp.model.TransferInput;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService {

    public SelectedTransfer getMaximumCost(TransferInput transferInput) {
        int maxWeight = transferInput.getMaxWeight();
        List<Transfer> transfers = transferInput.getAvailableTransfers();

        int[] dp = new int[maxWeight + 1];
        boolean[][] keep = new boolean[transfers.size()][maxWeight + 1];

        for (int i = 0; i < transfers.size(); i++) {
            int cost = transfers.get(i).getCost();
            int weight = transfers.get(i).getWeight();

            for (int w = maxWeight; w >= weight; w--) {
                if (dp[w - weight] + cost > dp[w]) {
                    dp[w] = dp[w - weight] + cost;
                    keep[i][w] = true;
                }
            }
        }

        List<Transfer> selectedTransfers = new ArrayList<>();
        int totalWeight = 0;
        for (int i = transfers.size() - 1, w = maxWeight; i >= 0; i--) {
            if (keep[i][w]) {
                selectedTransfers.add(transfers.get(i));
                totalWeight += transfers.get(i).getWeight();
                w -= transfers.get(i).getWeight();
            }
        }

        return new SelectedTransfer(selectedTransfers, dp[maxWeight], totalWeight);
    }
}