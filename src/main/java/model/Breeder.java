package model;

import exceptions.InvalidPokeStringException;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import util.PokeBagSorter;

public @Data
class Breeder {

    private PokeBag pokeBag;

    public Breeder() {
        this.pokeBag = new PokeBag();
    }

    /**
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
            return pokeBag.add(pokemon);
        } catch (Exception e) {
            throw new InvalidPokeStringException(e.getMessage());
        }
    }

    public void arrangePokeMons(PokeBag opponetPokeBag) {

        PokeBagSorter sorter = new PokeBagSorter();
        sorter.sort(this.pokeBag, opponetPokeBag);
    }
}
