package com.modyo.response.berry.firmness;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NameResponse {
    private final String name;
    private final LanguageResponse language;
}
