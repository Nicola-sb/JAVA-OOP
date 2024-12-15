package Logger.Appenders;

import Logger.Interfaces.Appender;
import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public abstract class BaseAppender implements Appender {

    Layout layout;
    private ReportLevel reportLevel;

    private static final ReportLevel DEFAULT_REPORT_LEVER=ReportLevel.INFO;

    private int messageCount;

    public BaseAppender(Layout layout) {
        this(layout,DEFAULT_REPORT_LEVER);
    }

    public BaseAppender(Layout layout,ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel=reportLevel;
        this.messageCount=0;
    }

    public boolean canAppend(ReportLevel reportLevel){
        return this.reportLevel.ordinal()<=reportLevel.ordinal();
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public void increaseMessageCount(){
        messageCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                reportLevel,messageCount);
    }
}
