package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {

//    private TableRepository<Table>tableTableRepository;
    private Collection<Table>tables;

    public TableRepositoryImpl() {
        tables=new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return tables;
    }

    @Override
    public void add(Table entity) {
       tables.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        //T byNumber(int tableNumber)
        //Returns an entity with that name
      return   this.tables.stream().filter( number12 -> number12.getTableNumber() == number).findFirst().orElse(null);

    }
}
