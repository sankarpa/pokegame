package model;


import lombok.Data;

import java.util.*;


public @Data
class PokeBag {

    private HashMap<PokemonType,Pokemon> pokemonSet = new LinkedHashMap<>();
    private List<Pokemon> sortedPokemons = new ArrayList<>();

    /**
     *
     * @param pokemon
     * @return true if bag has less than 5 pokemons and no pokemon of the type added else false
     */
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

    public Pokemon getPokemon(PokemonType type) {
        return pokemonSet.get(type);
    }

    public List<Pokemon> getAllPokemons(){
        return new ArrayList<Pokemon>(pokemonSet.values());
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        final String[] prefix = {""};
        if (sortedPokemons.isEmpty()){
            getAllPokemons().forEach( pokemon -> {
                builder.append(prefix[0]);
                prefix[0] =";";
                builder.append(pokemon.getType()).append("#").append(pokemon.getLevel());
            });
        }else{
            sortedPokemons.forEach(pokemon->{
                builder.append(prefix[0]);
                prefix[0] =";";
                builder.append(pokemon.getType()).append("#").append(pokemon.getLevel());
            });
        }

        return builder.toString();
    }
}
