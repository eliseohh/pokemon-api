package com.modyo.response.berry.flavor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContestTypeResponse {
    private String name;
    private String url;
}
