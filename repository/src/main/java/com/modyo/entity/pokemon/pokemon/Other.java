package com.modyo.entity.pokemon.pokemon;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Other {
    private DreamWorld dreamWorld;
    private Home home;
    @JsonAlias("official-artwork")
    private OfficialArtwork officialArtwork;
}
