package com.modyo.mapper.pokemon;

import com.modyo.entity.evolution.Chain;
import com.modyo.entity.evolution.EvolutionChain;
import com.modyo.entity.pokemon.pokemon.Pokemon;
import com.modyo.response.pokemon.AbilityPokemonResponse;
import com.modyo.response.pokemon.EvolutionPokemonResponse;
import com.modyo.response.pokemon.PokemonResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Component
public class PokemonResponseMapper implements BiFunction<Pokemon, EvolutionChain, PokemonResponse> {
    @Override
    public PokemonResponse apply(Pokemon pokemon, EvolutionChain evolutionChain) {
        final String pokemonType = pokemon.getTypes().stream().map(el -> el.getType().getName()).collect(Collectors.joining(", "));
        final List<AbilityPokemonResponse> abilities = pokemon.getAbilities().stream().map(el -> AbilityPokemonResponse.builder()
                .name(el.getAbility().getName())
                .build()).collect(Collectors.toList());
        final String pokemonName = pokemon.getName();
        return PokemonResponse.builder()
                .type(pokemonType)
                .name(pokemonName)
                .weight(pokemon.getWeight())
                .abilities(abilities)
                .description(String.format("%s, This pokemon is type(s) %s", pokemonName, pokemonType))
                .evolutions(evolutionChain(evolutionChain.getChain()))
                .build();
    }

    private List<EvolutionPokemonResponse> evolutionChain(Chain chain) {
        String evolutions = getEvolutions(chain);

        assert evolutions != null;
        return Arrays.stream(evolutions.split(","))
                .map(el -> EvolutionPokemonResponse.builder().name(el).build())
                .collect(Collectors.toList());
    }

    private String getEvolutions(Chain chain) {

        String evolutionDescription = chain.getSpecies().getName();
        Optional<Chain> first = chain.getEvolvesTo().stream().findFirst();

        if (first.isPresent())
            return evolutionDescription + "," + getEvolutions(first.get());

        return evolutionDescription;
    }
}
