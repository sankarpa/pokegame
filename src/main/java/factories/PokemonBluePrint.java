package factories;

import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;
import model.Pokemon;
import model.PokemonType;

@Blueprint(Pokemon.class)
public class PokemonBluePrint {

    @Default
    PokemonType type = PokemonType.ELECTRIC;
    @Default
    Integer xp = 1000;
    @Default
    Integer level = 10;
}
