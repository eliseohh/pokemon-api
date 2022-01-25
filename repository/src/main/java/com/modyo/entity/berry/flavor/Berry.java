package com.modyo.entity.berry.flavor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Berry {
    private final int potency;
    private final BerryDetails berry;
}
