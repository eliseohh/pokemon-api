package com.modyo.response.berry;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FlavorResponse {
    private final int potency;
    private final FlavorDetailResponse flavor;
}