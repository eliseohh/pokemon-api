package com.modyo.response.pokemon;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EvolutionPokemonResponse {
    private final String name;
}
