package Logger.layout;

import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public class SimpleLayout implements Layout {
    //Layouy=format;
    //SimpleLayout=SimpleFormat


    @Override
    public String format(String time, String message, ReportLevel reportLever) {
        return String.format("%s - %s - %s",time,reportLever,message);
    }

    //SimpleLayouet e готов и вече знаем в какъв формат ще искаме да логваме съобщенията
}
