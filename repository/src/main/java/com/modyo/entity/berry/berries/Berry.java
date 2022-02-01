package com.modyo.entity.berry.berries;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class Berry {
    private int id;
    private String name;
    private int growthTime;
    private int maxHarvest;
    private int naturalGiftPower;
    private int size;
    private int smoothness;
    private int soilDryness;
    private Firmness firmness;
    private ArrayList<Flavor> flavors;
    private Item item;
    private NaturalGiftType naturalGiftType;
}
