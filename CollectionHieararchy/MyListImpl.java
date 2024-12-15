package CollectionHieararchy;

public class MyListImpl extends Collection implements MyList{
    //•	An add(String) method adds an item to the start of the collection.
    //•	A remove() method removes the first element in the collection.
    //•	A used field that displays the size of elements currently in the collection
    @Override
    public String remove() {
      return  items.remove(0);

    }

    @Override
    public int add(String item) {
        items.add(0,item);
        return 0;
    }

    @Override
    public int getUsed() {
        return items.size();
    }
}
