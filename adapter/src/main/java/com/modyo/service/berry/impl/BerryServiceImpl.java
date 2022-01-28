package com.modyo.service.berry.impl;

import com.modyo.entity.berry.berries.Berry;
import com.modyo.entity.berry.firmness.BerryFirmness;
import com.modyo.entity.berry.flavor.BerryFlavors;
import com.modyo.mapper.berry.BerryMapper;
import com.modyo.mapper.berry.FirmnessMapper;
import com.modyo.mapper.berry.FlavorMapper;
import com.modyo.response.berry.berries.BerryResponse;
import com.modyo.response.berry.firmness.BerryFirmnessResponse;
import com.modyo.response.berry.flavor.BerryFlavorsResponse;
import com.modyo.service.BerriesService;
import com.modyo.service.berry.BerryService;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BerryServiceImpl implements BerryService {
    private final Function<BerryFirmness, BerryFirmnessResponse> firmnessMapper;
    private final Function<Berry, BerryResponse> berryMapper;
    private final Function<BerryFlavors, BerryFlavorsResponse> flavorMapper;
    private final BerriesService berriesService;


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
