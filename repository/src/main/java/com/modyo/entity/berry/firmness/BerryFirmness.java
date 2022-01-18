package com.modyo.entity.berry.firmness;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class BerryFirmness
{
    private int id;
    private String name;
    private ArrayList<Berry> berries;
    private ArrayList<Name> names;
}
