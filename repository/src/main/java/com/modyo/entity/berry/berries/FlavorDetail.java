package com.modyo.entity.berry.berries;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FlavorDetail {
    private final String name;
    private final String url;
}
