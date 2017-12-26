package util;

import comparator.PokemonCompartor;
import model.PokeBag;
import model.Pokemon;
import model.PokemonType;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class PokemonChooser {
    private PokeBag pokeBag;

    public PokemonChooser(PokeBag myPokeBag) {
        this.pokeBag = myPokeBag;
    }

    public PokemonChooserResult findAggressivePokemonByType(Pokemon pokemon) {

        PokemonChooserResult result = new PokemonChooserResult(pokemon);

        if (pokemon.getType() == PokemonType.WATER) {
            result.add(pokeBag.getPokemon(PokemonType.ELECTRIC));
            result.add(pokeBag.getPokemon(PokemonType.WATER));

        } else if (pokemon.getType() == PokemonType.GRASS) {
            result.add(pokeBag.getPokemon(PokemonType.FIRE));
            result.add(pokeBag.getPokemon(PokemonType.GRASS));

        } else if (PokemonType.ELECTRIC == pokemon.getType()) {
            result.add(pokeBag.getPokemon(PokemonType.GRASS));
            result.add(pokeBag.getPokemon(PokemonType.GHOST));
            result.add(pokeBag.getPokemon(PokemonType.FIGHTING));
            result.add(pokeBag.getPokemon(PokemonType.ELECTRIC));

        } else if (PokemonType.GHOST == pokemon.getType()) {
            result.add(pokeBag.getPokemon(PokemonType.FIRE));
            result.add(pokeBag.getPokemon(PokemonType.PSYCHIC));
            result.add(pokeBag.getPokemon(PokemonType.GHOST));

        } else if (pokemon.getType() == PokemonType.FIGHTING) {
            result.add(pokeBag.getPokemon(PokemonType.GRASS));
            result.add(pokeBag.getPokemon(PokemonType.GHOST));
            result.add(pokeBag.getPokemon(PokemonType.FIGHTING));
        } else if (pokemon.getType() == PokemonType.FIRE) {
            result.add(pokeBag.getPokemon(PokemonType.WATER));
            result.add(pokeBag.getPokemon(PokemonType.GHOST));
            result.add(pokeBag.getPokemon(PokemonType.FIRE));

        } else if (pokemon.getType() == PokemonType.PSYCHIC) {
            result.add(pokeBag.getPokemon(PokemonType.PSYCHIC));
        }

        result.getResultList().removeAll(Collections.singleton(null));

        if (result.getResultList().isEmpty()) {
            Optional<Pokemon> any = pokeBag.getAllPokemons().stream().filter(pokemon1 -> (pokemon.getLevel().equals(pokemon1.getLevel()) && pokemon1.isAvailable())).findFirst();
            if (any.isPresent()) {
                result.getResultList().add(any.get());
            }
        }

        if (result.getResultList().isEmpty()) {
            Optional<Pokemon> max = pokeBag.getAllPokemons().stream().filter(pokemon1 -> pokemon1.isAvailable()).max(Comparator.comparing(Pokemon::getLevel));
            if (max.isPresent()) {
                result.getResultList().add(max.get());
                result.setScore(new PokemonCompartor().compare(max.get(), pokemon));
            }
        }

        result.getResultList().stream().sorted(Comparator.comparing(pokemon1 -> pokemon.getLevel())).collect(Collectors.toList());
        return result;
    }
}
