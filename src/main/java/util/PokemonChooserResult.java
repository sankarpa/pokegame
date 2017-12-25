package util;

import comparator.PokemonCompartor;
import lombok.Data;
import model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public @Data
class PokemonChooserResult {

    PokemonCompartor compartor = new PokemonCompartor();
    private Pokemon opponentPokemon;
    private List<Pokemon> resultList;
    private Integer score = 0;

    private Logger log = LoggerFactory.getLogger(PokemonChooserResult.class);

    public PokemonChooserResult(Pokemon opponentPokemon) {
        this.opponentPokemon = opponentPokemon;
        this.resultList = new ArrayList<>();
    }

    public boolean add(Pokemon pokemon) {

        if ( (pokemon == null || (compartor.compare(pokemon, opponentPokemon)) < 0 || !pokemon.isAvailable())) {
            return false;
        }
        log.info("Pokemon {} has advantage over {}",pokemon,opponentPokemon);
        score = compartor.compare(pokemon, opponentPokemon);
        return resultList.add(pokemon);
    }

}
