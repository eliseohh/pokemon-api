package com.modyo.entity.pokemon.pokemon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ability {
    private Boolean isHidden;
    private Integer slot;
    private AbilityDetail ability;
}
