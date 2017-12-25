package model;


import lombok.Data;

public @Data class Pokemon implements Comparable {

    private PokemonType type;
    private Integer level;
    private boolean available = true;

    public Pokemon(){

    }

    public Pokemon(PokemonType type, Integer level) {
        this.type = type;
        this.level = level;
    }


    @Override
    public int compareTo(Object o2) {

        if( o2 instanceof Pokemon) {
            Pokemon pokemon = (Pokemon) o2;
            if (this.equals(o2)) {
                return 0;
            } else if (this.getLevel() >= (2 * this.getLevel())) {
                return -1;
            } else if (this.getType() == PokemonType.FIRE && (pokemon.getType() == PokemonType.GRASS || pokemon.getType() == PokemonType.GHOST)) {
                return 1;
            } else if (this.getType() == PokemonType.WATER && pokemon.getType() == PokemonType.FIRE) {
                return 1;
            } else if (this.getType() == PokemonType.GRASS && (pokemon.getType() == PokemonType.ELECTRIC || pokemon.getType() == PokemonType.FIGHTING)) {
                return 1;
            } else if (this.getType() == PokemonType.ELECTRIC && pokemon.getType() == PokemonType.WATER) {
                return 1;
            } else if (this.getType() == PokemonType.PSYCHIC && pokemon.getType() == PokemonType.GHOST) {
                return 1;
            } else if (this.getType() == PokemonType.GHOST && (pokemon.getType() == PokemonType.FIGHTING
                    || pokemon.getType() == PokemonType.ELECTRIC)) {
                return 1;
            } else if (this.getType() == PokemonType.FIGHTING && pokemon.getType() == PokemonType.ELECTRIC) {
                return 1;
            }
        }

        return -1;
    }
}
