package com.modyo.entity.pokemon.pokemon;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PastType {
    private Generation generation;
    private List<Type> types;
}
