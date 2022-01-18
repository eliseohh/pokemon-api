package com.modyo.repository;

import com.modyo.entity.berry.Berry;
import com.modyo.entity.berry.BerryFirmness;
import com.modyo.entity.berry.Firmness;

public interface BerryRepository {
    Berry findBerryByNameOrId(String id);

    BerryFirmness findFirmnessByIdOrName(String id);
}
