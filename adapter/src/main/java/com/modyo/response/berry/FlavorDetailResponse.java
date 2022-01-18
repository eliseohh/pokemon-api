package com.modyo.response.berry;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FlavorDetailResponse {
    private final String name;
    private final String url;
}
