package model;


import lombok.Data;

public @Data class Pokemon {

    private PokemonType type;
    private Integer xp;
    private Integer level;

    public Pokemon(){

    }

    public Pokemon(PokemonType type, Integer xp, Integer level) {
        this.type = type;
        this.xp = xp;
        this.level = level;
    }
}
