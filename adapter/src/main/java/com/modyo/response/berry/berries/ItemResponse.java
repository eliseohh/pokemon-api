package com.modyo.response.berry.berries;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemResponse {
    private final String name;
    private final String url;
}