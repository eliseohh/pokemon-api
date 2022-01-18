package com.modyo.response.berry.flavor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NamesResponse {
    private String name;
    private LanguageResponse language;
}
