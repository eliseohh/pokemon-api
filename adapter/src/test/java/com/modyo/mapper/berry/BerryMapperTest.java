package com.modyo.mapper.berry;

import com.modyo.entity.berry.berries.*;
import com.modyo.response.berry.berries.BerryResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Function;

class BerryMapperTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void apply() {
        //arrange
        Function<Berry, BerryResponse> berryMapper = new BerryMapper();

        Firmness firmness = new Firmness();
        firmness.setName("some_name");
        firmness.setUrl("some_url");

        Flavor flavor = new Flavor();
        FlavorDetail flavorDetail = FlavorDetail.builder()
                .name("some_name")
                .url("some_url")
                .build();
        flavor.setFlavor(flavorDetail);
        flavor.setPotency(0);

        ArrayList<Flavor> flavors = new ArrayList<>();
        flavors.add(flavor);

        Item item = new Item();
        item.setName("some_name");
        item.setUrl("some_url");

        NaturalGiftType naturalGiftType = new NaturalGiftType();
        naturalGiftType.setName("some_name");
        naturalGiftType.setUrl("some_url");

        Berry berry = Berry.builder()
                .id(0)
                .name("some_name")
                .growthTime(0)
                .maxHarvest(0)
                .naturalGiftPower(0)
                .size(0)
                .smoothness(0)
                .soilDryness(0)
                .firmness(firmness)
                .flavors(flavors)
                .item(item)
                .naturalGiftType(naturalGiftType)
                .build();

        //act
        BerryResponse response = berryMapper.apply(berry);

        //assert
        Assertions.assertEquals(0, response.getId());
        Assertions.assertEquals("some_name", response.getName());
        Assertions.assertEquals(0, response.getGrowthTime());
        Assertions.assertEquals(0, response.getMaxHarvest());
        Assertions.assertEquals(0, response.getNaturalGiftPower());
        Assertions.assertEquals(0, response.getSize());
        Assertions.assertEquals(0, response.getSmoothness());
        Assertions.assertEquals(0, response.getSoilDryness());

        Assertions.assertNotNull(response.getFirmness());
        Assertions.assertEquals("some_name", response.getFirmness().getName());
        Assertions.assertEquals("some_url", response.getFirmness().getUrl());

        Assertions.assertNotNull(response.getItem());
        Assertions.assertEquals("some_name", response.getItem().getName());
        Assertions.assertEquals("some_url", response.getItem().getUrl());

        Assertions.assertNotNull(response.getFlavors());
        Assertions.assertEquals(1, response.getFlavors().size());
        Assertions.assertEquals(0, response.getFlavors().get(0).getPotency());
        Assertions.assertNotNull(response.getFlavors().get(0).getFlavor());
        Assertions.assertEquals("some_name", response.getFlavors().get(0).getFlavor().getName());
        Assertions.assertEquals("some_url", response.getFlavors().get(0).getFlavor().getUrl());

        Assertions.assertNotNull(response.getNaturalGiftType());
        Assertions.assertEquals("some_name", response.getNaturalGiftType().getName());
        Assertions.assertEquals("some_url", response.getNaturalGiftType().getUrl());
    }
}