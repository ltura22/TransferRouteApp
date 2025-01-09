package com.example.TransferRouteApp.model;

import java.util.Objects;

public class Transfer {
    private int cost;
    private int weight;

    public Transfer(int cost, int weight){
        this.weight = weight;
        this.cost = cost;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getCost(){
        return this.cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Transfer(cost=" + cost + ",weight=" + weight + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return cost == transfer.cost && weight == transfer.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, weight);
    }
}
