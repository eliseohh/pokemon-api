package com.modyo.response.berry.flavor;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Builder
public class BerryFlavorsResponse {
    private int id;
    private String name;
    private ArrayList<BerryResponse> berries;
    private ContestTypeResponse contestType;
    private ArrayList<NamesResponse> names;
}
