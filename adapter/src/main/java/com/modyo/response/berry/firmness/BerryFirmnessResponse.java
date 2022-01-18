package com.modyo.response.berry.firmness;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Builder
public class BerryFirmnessResponse
{
    private int id;
    private String name;
    private ArrayList<Berry> berries;
    private ArrayList<NameResponse> names;
}
