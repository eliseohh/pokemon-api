package com.modyo.response.berry;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Builder
public class BerryResponse {
    private final int id;
    private final String name;
    private final int growthTime;
    private final int maxHarvest;
    private final int naturalGiftPower;
    private final int size;
    private final int smoothness;
    private final int soilDryness;
    private final FirmnessResponse firmness;
    private final ArrayList<FlavorResponse> flavors;
    private final ItemResponse item;
    private final NaturalGiftType naturalGiftType;
}
