package com.modyo.response.berry;

import lombok.Builder;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Builder
public class BerryFirmnessResponse
{
    private int id;
    private String name;
    private ArrayList<BerryResponse> berries;
    private ArrayList<NameResponse> names;
}
