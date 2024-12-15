package MilitaryElite;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral{

    private List<Private>privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.privates=new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }
}
