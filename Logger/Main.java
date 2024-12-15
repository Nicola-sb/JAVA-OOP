package Logger;

import Logger.Appenders.FileAppender;
import Logger.Appenders.LogFile;
import Logger.Factories.LoggerFactory;
import Logger.Interfaces.Appender;
import Logger.Interfaces.File;
import Logger.Interfaces.Layout;
import Logger.Interfaces.Logger;
import Logger.Appenders.ConsoleAppender;
import Logger.enums.ReportLevel;
import Logger.impl.MessageLogger;
import Logger.layout.SimpleLayout;
import Logger.layout.XmlLayout;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


             InputParser inputParser=new InputParser();
             Scanner scanner = new Scanner(System.in);
             LoggerFactory loggerFactory=new LoggerFactory();
             Logger logger=loggerFactory.produce(inputParser.readLineInput(scanner));

             System.out.println(logger);

             String input=scanner.nextLine();
             while (!input.equals("END")){
                 String[]tokens=input.split("\\|");

                 ReportLevel reportLevel=ReportLevel.valueOf(tokens[0]);
                 String time=tokens[1];
                 String message=tokens[2];

                 switch (reportLevel){
                     case INFO : logger.logInfo(time,message);break;
                     case WARNING: logger.logWarning(time,message);break;
                     case ERROR:  logger.logError(time,message);break;
                     case CRITICAL:  logger.logCritical(time,message);break;
                     case FATAL:  logger.logFatal(time,message);break;
                 }

                 input=scanner.nextLine();
             }
    }
}
