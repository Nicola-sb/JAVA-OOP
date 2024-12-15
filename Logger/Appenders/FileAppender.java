package Logger.Appenders;

import Logger.Interfaces.File;
import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public class FileAppender extends BaseAppender {

//    Layout layout;

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file=new LogFile();
    }
    public FileAppender(Layout layout, String fileName) {
        this(layout);
        this.file=new LogFile(fileName);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if(this.canAppend(reportLevel)){
            String outputText=this.layout.format(time,message,reportLevel);
            increaseMessageCount();
            file.append(outputText);
        }
    }
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        //File size: 37526
        //Изполваме си toString ot BaseAppender и само си добавямме  + ", File size: " + this.file.getSize();
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
