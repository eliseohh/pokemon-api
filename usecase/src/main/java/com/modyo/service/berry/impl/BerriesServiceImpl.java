package com.modyo.service.berry.impl;

import com.modyo.entity.berry.berries.Berry;
import com.modyo.entity.berry.firmness.BerryFirmness;
import com.modyo.entity.berry.flavor.BerryFlavors;
import com.modyo.repository.BerryRepository;
import org.springframework.stereotype.Service;
import com.modyo.service.BerriesService;

@Service
public class BerriesServiceImpl implements BerriesService {

    private final BerryRepository berryRepository;

    public BerriesServiceImpl(BerryRepository berryRepository) {
        this.berryRepository = berryRepository;
    }

    @Override
    public Berry findBerryByIdOrName(String id) {
        return berryRepository.findBerryByNameOrId(id);
    }

    @Override
    public BerryFirmness findFirmnessByIdOrName(String id) {
        return berryRepository.findFirmnessByIdOrName(id);
    }

    @Override
    public BerryFlavors findFlavorByIdOrName(String id) {
        return berryRepository.findFlavorByIdOrName(id);
    }
}
