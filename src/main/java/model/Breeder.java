package model;

import lombok.Data;

public @Data class Breeder {

    private PokemonWallet pokemonWallet;

    public Breeder() {
        this.pokemonWallet = new PokemonWallet();
    }

}
