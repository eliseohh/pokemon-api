package com.modyo.response.berry.flavor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BerryResponse {
    private int potency;
    private BerryDetailsResponse berry;
}
