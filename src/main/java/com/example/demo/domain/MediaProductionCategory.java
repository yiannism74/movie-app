package com.example.demo.domain;

public enum MediaProductionCategory {

    TVSHOW("TV Show"),FILM("Film");

    private final String productionCategory;

    MediaProductionCategory(String productionCategory) {
        this.productionCategory = productionCategory;
    }

    public String getProductionCategory() {
        return this.productionCategory;
    }

}
