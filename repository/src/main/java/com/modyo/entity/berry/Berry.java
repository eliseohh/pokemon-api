package com.modyo.entity.berry;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Builder
public class Berry {
    private final int id;
    private final String name;
    private final int growthTime;
    private final int maxHarvest;
    private final int naturalGiftPower;
    private final int size;
    private final int smoothness;
    private final int soilDryness;
    private final Firmness firmness;
    private final ArrayList<Flavor> flavors;
    private final Item item;
    private final NaturalGiftType naturalGiftType;
}
