package Logger.Interfaces;

import Logger.enums.ReportLevel;

public interface Layout {
    //Layout==format

////Трябва да взима съобение,репорт левъл,
//    //"<date-time> - <report level> - <message и да ги форматирам по определен начин за да може след това
    //appender да ги аппендне форматирани към някой от информациониите канали

    //ЗАЩО го направихме като интерфейс?
    //-Защоте ще имаме различни видове Layouts

//    String format(String time,String message,String reportLever);
    String format(String time, String message, ReportLevel reportLever);


    //Щом знаем,че имаме точно 5 вида лог,можем да си ги намравпим като ENUM и мога да си ги държа не като Стринг,а като ЕНЪМ
}
