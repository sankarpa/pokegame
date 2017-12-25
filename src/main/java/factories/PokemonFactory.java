package factories;

import com.tobedevoured.modelcitizen.CreateModelException;
import com.tobedevoured.modelcitizen.ModelFactory;
import com.tobedevoured.modelcitizen.RegisterBlueprintException;
import model.Pokemon;
import model.PokemonType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PokemonFactory {

    private static ModelFactory modelFactory = new ModelFactory();

    static {
        try {
            modelFactory.registerBlueprint(PokemonBluePrint.class);
        } catch (RegisterBlueprintException e) {
            System.exit(1);
        }
    }


    public static Pokemon getPokemon(PokemonType pokemonType){
        Pokemon pokemon = getPokemon();
        pokemon.setType(pokemonType);
        return pokemon;
    }

    public static Pokemon getPokemon() {
        Pokemon pokemon = null;
        try {
            pokemon = modelFactory.createModel(Pokemon.class);
        } catch (CreateModelException e) {
            e.printStackTrace();
        }
        return pokemon;
    }

    public static List<Pokemon> getCollectionOfPokemonForEachType(){
        List<Pokemon> pokemonList = new ArrayList<>();

        for(PokemonType type: PokemonType.values()){
            pokemonList.add(getPokemon(type));
        }
        return pokemonList;
    }

}
