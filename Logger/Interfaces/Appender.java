package Logger.Interfaces;

import Logger.enums.ReportLevel;

public interface Appender {



    //Appenders ще трябва да могат да апендват съобщения с помощта на Layout


    void append(String time, String message, ReportLevel reportLevel);
    void setReportLevel(ReportLevel reportLevel);
}
