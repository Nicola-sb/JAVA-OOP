package christmasPastryShop.repositories;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.ArrayList;
import java.util.Collection;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {

    private Collection<Cocktail>cocktails;

    public CocktailRepositoryImpl() {
        cocktails=new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return cocktails.stream().filter( name1 -> name1.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return cocktails;
    }

    @Override
    public void add(Cocktail cocktail) {
      cocktails.add(cocktail);
    }
}
