package Logger.impl;

import Logger.Interfaces.Appender;
import Logger.Interfaces.Logger;
import Logger.enums.ReportLevel;

import java.util.Arrays;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    //Whenever a logger is told to log something, it calls all of its appenders and tells them to append the message.
// In turn, the appenders append the message (e.g. to the console or a file) according to the layout they have.
    @Override
    public void logInfo(String time, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(time, message, ReportLevel.INFO));
        //Така ще можем когато логвамеИнфо(logInfo) да преминем през нашите аппендърс и да им апенднем съобщението
        //Те са свой ред ще форматират съобщението и ще го пратят на правилния комуникационен канал
    }

    @Override
    public void logWarning(String time, String message) {
//        Arrays.stream(appenders).forEach(appender -> appender.append(time,message, ReportLevel.WARNING));
        log(time, message, ReportLevel.INFO);
    }

    @Override
    public void logError(String time, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(time, message, ReportLevel.ERROR));
    }

    @Override
    public void logCritical(String time, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(time, message, ReportLevel.CRITICAL));
    }

    @Override
    public void logFatal(String time, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(time, message, ReportLevel.FATAL));
    }

    private void log(String time, String message, ReportLevel reportLevel) {
        for (Appender appender : appenders) {
            appender.append(time, message, reportLevel);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info");
        builder.append(System.lineSeparator());
        for (Appender apender : appenders) {
            builder.append(apender);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
