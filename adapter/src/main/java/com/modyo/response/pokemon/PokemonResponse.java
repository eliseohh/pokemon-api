package com.modyo.response.pokemon;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PokemonResponse {
    private final String type;
    private final Integer weight;
    private final List<AbilityPokemonResponse> abilities;
    private final String description;
    private final List<EvolutionPokemonResponse> evolutions;
}
