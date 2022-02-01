package com.modyo.entity.berry.flavor;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BerryFlavors {
    private int id;
    private String name;
    private ArrayList<Berry> berries;
    private ContestType contestType;
    private ArrayList<Names> names;
}
