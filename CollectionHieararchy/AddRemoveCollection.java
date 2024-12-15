package CollectionHieararchy;

public class AddRemoveCollection extends Collection implements AddRemovable{
    //•	An add(String) method – which adds an item to the start of the collection.
    //•	A remove() method removes the last item in the collection
    @Override
    public String remove() {
        return items.remove(items.size()-1);

    }

    @Override
    public int add(String item) {
        items.add(0,item);
        return 0;
    }
}
