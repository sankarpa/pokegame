package model;


import java.util.HashMap;


public class PokemonWallet {

    private HashMap<PokemonType,Pokemon> pokemonSet = new HashMap<>();

    public boolean add(Pokemon pokemon) {
        if( size() >= 5 || pokemonSet.containsKey(pokemon.getType())){
            return  false;
        }
        pokemonSet.put(pokemon.getType(),pokemon);
        return true;
    }

    public int size() {
        return pokemonSet.size();
    }

    public Pokemon getPokemonType(PokemonType type) {
        return pokemonSet.get(type);
    }
}
