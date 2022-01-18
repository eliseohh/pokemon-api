package com.modyo.service;

import com.modyo.entity.berry.Berry;
import com.modyo.entity.berry.Firmness;

public interface BerriesService {
    Berry findBerryByIdOrName(String id);
    Firmness findFirmnessByIdOrName(String id);
}
