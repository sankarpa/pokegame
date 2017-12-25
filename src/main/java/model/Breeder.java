package model;

import exceptions.InvalidPokeStringException;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public @Data class Breeder {

    private PokeBag pokeBag;
    private Logger log = LoggerFactory.getLogger(Breeder.class);

    public Breeder() {
        this.pokeBag = new PokeBag();
    }

    /**
     *
     * @param pokeString
     * @return
     * @throws InvalidPokeStringException
     */
    public boolean addToBag(String pokeString) throws InvalidPokeStringException {

        try {
            if (StringUtils.isBlank(pokeString) || !pokeString.contains("#")) {
                throw new InvalidPokeStringException("String is Empty or Not contains delimiter #");
            }
            String[] pokeMonParams = pokeString.split("#");
            PokemonType pokemonType = PokemonType.valueOf(pokeMonParams[0].toUpperCase());
            Integer level = new Integer(pokeMonParams[1]);
            Pokemon pokemon = new Pokemon(pokemonType, level);
            log.debug("Adding Pokemon {} to Breeder poke wallet", pokemon.toString());
            return pokeBag.add(pokemon);
        }catch (Exception e){
            throw new InvalidPokeStringException(e.getMessage());
        }
    }

    public void sortPokeMons(List<Pokemon> allPokemons) {
    }
}
