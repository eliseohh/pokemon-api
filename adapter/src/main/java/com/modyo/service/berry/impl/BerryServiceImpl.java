package com.modyo.service.berry.impl;

import com.modyo.mapper.berry.BerryMapper;
import com.modyo.mapper.berry.FirmnessMapper;
import com.modyo.mapper.berry.FlavorMapper;
import com.modyo.response.berry.berries.BerryResponse;
import com.modyo.response.berry.firmness.BerryFirmnessResponse;
import com.modyo.response.berry.flavor.BerryFlavorsResponse;
import com.modyo.service.BerriesService;
import com.modyo.service.berry.BerryService;
import org.springframework.stereotype.Service;

@Service
public class BerryServiceImpl implements BerryService {
    private final FirmnessMapper firmnessMapper;
    private final BerriesService berriesService;
    private final BerryMapper berryMapper;
    private final FlavorMapper flavorMapper;


    public BerryServiceImpl(FirmnessMapper firmnessMapper, BerriesService berriesService, BerryMapper berryMapper, FlavorMapper flavorMapper) {
        this.firmnessMapper = firmnessMapper;
        this.berriesService = berriesService;
        this.berryMapper = berryMapper;
        this.flavorMapper = flavorMapper;
    }


    @Override
    public BerryResponse obtainBerries(String id) {
        return berryMapper.apply(berriesService.findBerryByIdOrName(id));
    }

    @Override
    public BerryFirmnessResponse getFirmnessInformation(String id) {
        return firmnessMapper.apply(berriesService.findFirmnessByIdOrName(id));
    }

    @Override
    public BerryFlavorsResponse getFlavorsInformation(String id) {
        return flavorMapper.apply(berriesService.findFlavorByIdOrName(id));
    }
}
