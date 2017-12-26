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

    public void arrangePokeMons(PokeBag opponetPokeBag) {

        PokeBagSorter sorter = new PokeBagSorter();
        sorter.sort(this.pokeBag, opponetPokeBag);
    }
}
