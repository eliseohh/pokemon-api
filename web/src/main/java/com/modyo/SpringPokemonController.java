package com.modyo;

import com.modyo.controller.PokemonController;
import com.modyo.response.pokemon.PokemonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class SpringPokemonController {

    private final PokemonController pokemonController;

    public SpringPokemonController(PokemonController pokemonController) {
        this.pokemonController = pokemonController;
    }

    @GetMapping("/{id}")
    public PokemonResponse getPokemon(@PathVariable("id") String id){
        return pokemonController.getPokemonInfo(id);
    }
}
