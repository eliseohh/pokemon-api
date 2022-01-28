package com.modyo.response.berry.berries;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FirmnessResponse {
    private final String name;
    private final String url;
}