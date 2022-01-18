package com.modyo.response.berry;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class NameResponse {
    private final String name;
    private final LanguageResponse language;
}
