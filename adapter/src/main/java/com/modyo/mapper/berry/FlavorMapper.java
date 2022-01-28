package com.modyo.mapper.berry;

import com.modyo.entity.berry.flavor.BerryFlavors;
import com.modyo.response.berry.flavor.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FlavorMapper implements Function<BerryFlavors, BerryFlavorsResponse> {
    @Override
    public BerryFlavorsResponse apply(BerryFlavors berryFlavors) {
        return BerryFlavorsResponse.builder()
                .id(berryFlavors.getId())
                .name(berryFlavors.getName())
                .berries(berryFlavors.getBerries()
                        .stream()
                        .map(el -> BerryResponse.builder()
                                .potency(el.getPotency())
                                .berry(BerryDetailsResponse.builder()
                                        .name(el.getBerry().getName())
                                        .url(el.getBerry().getUrl())
                                        .build())
                                .build())
                        .collect(Collectors.toCollection(ArrayList::new)))
                .contestType(ContestTypeResponse.builder()
                        .name(berryFlavors.getContestType().getName())
                        .url(berryFlavors.getContestType().getUrl())
                        .build())
                .names(berryFlavors.getNames().stream()
                        .map(el -> NamesResponse.builder()
                                .name(el.getName())
                                .language(LanguageResponse.builder()
                                        .name(el.getLanguage().getName())
                                        .url(el.getLanguage().getUrl())
                                        .build())
                                .build())
                        .collect(Collectors.toCollection(ArrayList::new)))
                .build();
    }
}
