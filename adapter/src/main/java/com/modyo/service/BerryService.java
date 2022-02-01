package com.modyo.service;

import com.modyo.response.berry.berries.BerryResponse;
import com.modyo.response.berry.firmness.BerryFirmnessResponse;
import com.modyo.response.berry.flavor.BerryFlavorsResponse;

public interface BerryService {
    BerryResponse obtainBerries(String id);

    BerryFirmnessResponse getFirmnessInformation(String id);

    BerryFlavorsResponse getFlavorsInformation(String id);
}
