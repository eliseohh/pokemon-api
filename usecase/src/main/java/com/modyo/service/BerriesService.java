package com.modyo.service;

import com.modyo.entity.berry.berries.Berry;
import com.modyo.entity.berry.firmness.BerryFirmness;
import com.modyo.entity.berry.flavor.BerryFlavors;

public interface BerriesService {
    Berry findBerryByIdOrName(String id);

    BerryFirmness findFirmnessByIdOrName(String id);

    BerryFlavors findFlavorByIdOrName(String id);
}
