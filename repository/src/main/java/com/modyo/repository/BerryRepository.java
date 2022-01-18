package com.modyo.repository;

import com.modyo.entity.berry.berries.Berry;
import com.modyo.entity.berry.firmness.BerryFirmness;
import com.modyo.entity.berry.flavor.BerryFlavors;

public interface BerryRepository {
    Berry findBerryByNameOrId(String id);

    BerryFirmness findFirmnessByIdOrName(String id);

    BerryFlavors findFlavorByIdOrName(String id);
}
