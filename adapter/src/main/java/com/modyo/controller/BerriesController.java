package com.modyo.controller;

import com.modyo.response.berry.berries.BerryResponse;
import com.modyo.response.berry.firmness.BerryFirmnessResponse;
import com.modyo.response.berry.flavor.BerryFlavorsResponse;
import com.modyo.service.berry.BerryService;
import org.springframework.stereotype.Component;

@Component
public class BerriesController {

    private final BerryService berryService;

    public BerriesController(BerryService berryService) {
        this.berryService = berryService;
    }

    public BerryResponse berries(String id) {
        return berryService.obtainBerries(id);
    }

    public BerryFirmnessResponse firmness(String id) {
        return berryService.getFirmnessInformation(id);
    }

    public BerryFlavorsResponse flavors(String id) {
        return berryService.getFlavorsInformation(id);
    }

}
