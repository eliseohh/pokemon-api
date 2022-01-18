package com.modyo.mapper;

import com.modyo.entity.berry.BerryFirmness;
import com.modyo.response.berry.BerryFirmnessResponse;
import com.modyo.response.berry.BerryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FirmnessMapper implements Function<BerryFirmness, BerryFirmnessResponse> {
    //TODO: formatear berry a un tipo de berryfirmnessinnerresponseobject
    @Override
    public BerryFirmnessResponse apply(BerryFirmness berryFirmness) {
        return BerryFirmnessResponse.builder()
                .id(berryFirmness.getId())
                .name(berryFirmness.getName())
                .berries(berryFirmness.getBerries().stream().map(el -> BerryResponse.builder().name().url.build()).collect(Collectors.toCollection(ArrayList::new)))
                .names()
                .build();
    }
}
