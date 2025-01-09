package com.example.TransferRouteApp.controller;

import com.example.TransferRouteApp.model.SelectedTransfer;
import com.example.TransferRouteApp.model.TransferInput;
import com.example.TransferRouteApp.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final TransferService transferService;

    @Autowired
    public Controller(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping("/api/maximum-cost")
    public SelectedTransfer index(@RequestBody TransferInput transferInput){
        return transferService.getMaximumCost(transferInput);
    }

}
