package Logger.Appenders;

import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public class ConsoleAppender extends BaseAppender {

//    Layout layout;//Защо го направихме?Защото в апендърите тези ,които ще изпращата информацията и ще я записват някъде,трябва да знаем
    //как информацията ще бъде форматирана

    //Всеки един Appender(ConsoleAppender,FileAppender i др.) трябва да има layout за да знае къде да прати информацията

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    // //Всеки един от апендърите ще трбявА ДА пази вътре в себе си някакъв layout

    //След като имаме layout Ние вече можем да форматираме нашето съобщение и след това да го пратим към комуникационния канал
    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if(this.canAppend(reportLevel)){
            String formattedMessega=this.layout.format(time,message,reportLevel);
            //2ta стъпка е да го пратим към комуникационния канал-да го appendnem някъде
            increaseMessageCount();
            System.out.println(formattedMessega);
        }
    }



    //Имам се си апендър който апендва към конзолата?Как?Като принитра
}
