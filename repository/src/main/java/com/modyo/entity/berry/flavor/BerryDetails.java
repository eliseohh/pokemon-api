package com.modyo.entity.berry.flavor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BerryDetails {
    private final String name;
    private final String url;
}
