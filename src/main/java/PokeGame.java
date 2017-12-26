import exceptions.InvalidPokeStringException;
import model.Breeder;
import model.PokeBag;
import model.Pokemon;
import model.PokemonType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokeGame {

    public static void main(String[] args) throws InvalidPokeStringException {

        Scanner in = new Scanner(System.in);

        PokeGame game = new PokeGame();

        String breederInput = in.nextLine();
        Breeder breeder = game.createBreeder(breederInput.trim());
        System.out.println(breeder.toString());

        String opponentInput = in.nextLine();
        Breeder opponentBreeder = game.createBreeder(opponentInput.trim());
        System.out.println(opponentBreeder.toString());


        game.startGame(breeder, opponentBreeder);
    }

    public List<Pokemon> generatePokemons(String input) throws InvalidPokeStringException {
        List<Pokemon> pokemons = new ArrayList<>();
        try {
            String[] pokeStrings = input.split(";");
            for (String pokeString : pokeStrings) {
                String[] pokeMonParams = pokeString.split("#");
                PokemonType pokemonType = PokemonType.valueOf(pokeMonParams[0].toUpperCase());
                Integer level = new Integer(pokeMonParams[1]);
                Pokemon pokemon = new Pokemon(pokemonType, level);
                pokemons.add(pokemon);
            }
            return pokemons;
        } catch (Exception e) {
            throw new InvalidPokeStringException(e.getMessage() + "Please enter valid input string");
        }
    }

    public Breeder createBreeder(String input) throws InvalidPokeStringException {

        List<Pokemon> pokemons = generatePokemons(input);
        if (pokemons.isEmpty()) {
            return null;
        }
        Breeder breeder = new Breeder();
        for (Pokemon pokemon : pokemons)
            breeder.getPokeBag().add(pokemon);

        return breeder;
    }

    public void startGame(Breeder breeder, Breeder opponentBreeder) {

        PokeBag opponetPokeBag = opponentBreeder.getPokeBag();
        breeder.arrangePokeMons(opponetPokeBag);
    }
}
