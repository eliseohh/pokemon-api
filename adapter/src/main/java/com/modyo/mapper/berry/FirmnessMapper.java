package com.modyo.mapper.berry;

import com.modyo.entity.berry.firmness.BerryFirmness;
import com.modyo.response.berry.firmness.Berry;
import com.modyo.response.berry.firmness.BerryFirmnessResponse;
import com.modyo.response.berry.firmness.LanguageResponse;
import com.modyo.response.berry.firmness.NameResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FirmnessMapper implements Function<BerryFirmness, BerryFirmnessResponse> {
    @Override
    public BerryFirmnessResponse apply(BerryFirmness berryFirmness) {
        return BerryFirmnessResponse.builder()
                .name(berryFirmness.getName())
                .id(berryFirmness.getId())
                .berries(berryFirmness.getBerries().stream()
                        .map(el -> Berry.builder()
                                .url(el.getUrl())
                                .name(el.getName())
                                .build())
                        .collect(Collectors.toCollection(ArrayList::new)))
                .names(berryFirmness.getNames().stream().map(el -> NameResponse.builder()
                                .name(el.getName())
                                .language(LanguageResponse.builder()
                                        .name(el.getLanguage().getName())
                                        .url(el.getLanguage()
                                                .getUrl())
                                        .build())
                                .build())
                        .collect(Collectors.toCollection(ArrayList::new)))
                .build();
    }
}
