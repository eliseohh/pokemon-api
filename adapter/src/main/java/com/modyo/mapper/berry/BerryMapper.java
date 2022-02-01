package com.modyo.mapper.berry;

import com.modyo.entity.berry.berries.Berry;
import com.modyo.response.berry.berries.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BerryMapper implements Function<Berry, BerryResponse> {

    @Override
    public BerryResponse apply(Berry berry) {
        return BerryResponse.builder()
                .id(berry.getId())
                .name(berry.getName())
                .growthTime(berry.getGrowthTime())
                .maxHarvest(berry.getMaxHarvest())
                .naturalGiftPower(berry.getNaturalGiftPower())
                .size(berry.getSize())
                .smoothness(berry.getSmoothness())
                .soilDryness(berry.getSoilDryness())
                .firmness(FirmnessResponse.builder()
                        .name(berry.getFirmness().getName())
                        .url(berry.getFirmness().getUrl())
                        .build())
                .flavors(berry.getFlavors().stream().map(el -> FlavorResponse.builder()
                        .potency(el.getPotency())
                        .flavor(FlavorDetailResponse.builder()
                                .name(el.getFlavor().getName())
                                .url(el.getFlavor().getUrl())
                                .build())
                        .build()).collect(Collectors.toCollection(ArrayList::new)))
                .item(ItemResponse.builder()
                        .name(berry.getItem().getName())
                        .url(berry.getItem().getUrl())
                        .build())
                .naturalGiftType(NaturalGiftType.builder()
                        .name(berry.getNaturalGiftType().getName())
                        .url(berry.getNaturalGiftType().getUrl())
                        .build())
                .build();
    }
}
