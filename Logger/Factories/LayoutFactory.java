package Logger.Factories;

import Logger.Interfaces.Factory;
import Logger.Interfaces.Layout;
import Logger.layout.SimpleLayout;
import Logger.layout.XmlLayout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String input) {
        Layout layout=null;

        if(input.equals("SimpleLayout")){
            layout=new SimpleLayout();
        }else if(input.equals("XmlLayout")){
            layout=new XmlLayout();
        }

        return layout;
    }
}
