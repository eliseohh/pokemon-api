package com.modyo.mapper.pokemon;

import com.modyo.entity.pokemon.pokemon.Pokemon;
import com.modyo.response.pokemon.AbilityPokemonResponse;
import com.modyo.response.pokemon.PokemonResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PokemonResponseMapper implements Function<Pokemon, PokemonResponse> {
    @Override
    public PokemonResponse apply(Pokemon pokemon) {
        return PokemonResponse.builder()
                .type(pokemon.getTypes().stream().map(el -> el.getType().getName()).collect(Collectors.joining(",")))
                .weight(pokemon.getWeight())
                .abilities(pokemon.getAbilities().stream().map(el -> AbilityPokemonResponse.builder()
                        .name(el.getAbility().getName())
                        .build()).collect(Collectors.toList()))
                //TODO: description is missing
                //TODO: evolutions are remaining
                //TODO: evolutions are available in species.url
                .build();
    }
}
