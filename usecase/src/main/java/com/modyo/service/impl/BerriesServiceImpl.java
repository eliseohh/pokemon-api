package com.modyo.service.impl;

import com.modyo.entity.berry.Berry;
import com.modyo.entity.berry.BerryFirmness;
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
}
