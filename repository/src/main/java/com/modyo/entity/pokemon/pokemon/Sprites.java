package com.modyo.entity.pokemon.pokemon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sprites {
    private String backDefault;
    private String backFemale;
    private String backShiny;
    private String backShinyFemale;
    private String frontDefault;
    private String frontFemale;
    private String frontShiny;
    private String frontShinyFemale;
    private Other other;
}
