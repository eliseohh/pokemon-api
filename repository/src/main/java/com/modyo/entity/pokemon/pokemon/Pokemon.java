package com.modyo.entity.pokemon.pokemon;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pokemon {
    private Long id;
    private String name;
    private Integer baseExperience;
    private Integer height;
    private Boolean isDefault;
    private Integer order;
    private Integer weight;
    private List<Ability> abilities;
    private List<Form> forms;
    private List<GameIndex> gameIndices;
    private List<HeldItem> heldItems;
    private List<Move> moves;
    private Species species;
    private Sprites sprites;
    private List<Stat> stats;
    private List<Type> types;
    private List<PastType> pastTypes;
}
