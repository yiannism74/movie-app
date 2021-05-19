package com.example.demo.domain;

public enum ProductionCrewMemberRole {

    DIRECTOR("Director"),PRODUCER("Producer");

    private final String productionCrewMemberRole;

    ProductionCrewMemberRole(String productionCrewMemberRole) {
        this.productionCrewMemberRole = productionCrewMemberRole;
    }

    public String getProductionCrewMemberRole() {
        return this.productionCrewMemberRole;
    }

}
