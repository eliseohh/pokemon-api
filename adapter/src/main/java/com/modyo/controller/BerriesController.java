package com.modyo.controller;

import com.modyo.mapper.FirmnessMapper;
import com.modyo.response.berry.BerryResponse;
import com.modyo.response.berry.FirmnessResponse;
import com.modyo.mapper.BerryMapper;
import com.modyo.service.BerriesService;
import org.springframework.stereotype.Component;

@Component
public class BerriesController {

    private final BerriesService berriesService;
    private final BerryMapper berryMapper;
    private final FirmnessMapper firmnessMapper;

    public BerriesController(BerriesService berriesService, BerryMapper berryMapper, FirmnessMapper firmnessMapper) {
        this.berriesService = berriesService;
        this.berryMapper = berryMapper;
        this.firmnessMapper = firmnessMapper;
    }

    public BerryResponse berries(String id) {
        return berryMapper.apply(berriesService.findBerryByIdOrName(id));
    }

    public FirmnessResponse firmness(String id) { return  firmnessMapper.apply();}
}
