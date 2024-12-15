package goldDigger.models.museum;

import java.util.ArrayList;
import java.util.Collection;

public class BaseMuseum implements Museum{

    private Collection<String>exhibits;

    public BaseMuseum() {
        this.exhibits=new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    public void setExhibits(Collection<String> exhibits) {
        this.exhibits = exhibits;
    }

}
