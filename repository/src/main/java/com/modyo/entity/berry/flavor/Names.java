package com.modyo.entity.berry.flavor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Names {
    private final String name;
    private final Language language;
}
