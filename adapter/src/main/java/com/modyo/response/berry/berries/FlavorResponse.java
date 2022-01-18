package com.modyo.response.berry.berries;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FlavorResponse {
    private final int potency;
    private final FlavorDetailResponse flavor;
}