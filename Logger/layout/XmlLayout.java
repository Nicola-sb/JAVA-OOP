package Logger.layout;

import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public class XmlLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLever) {
        StringBuilder sb=new StringBuilder();
        sb.append("<log> ").append(System.lineSeparator());
        sb.append("   <date>").append(time).append("/<date>").append(System.lineSeparator());
        sb.append("   <level>").append(reportLever).append("</level>").append(System.lineSeparator());
        sb.append("   <message>").append(message).append("</message>").append(System.lineSeparator());
        sb.append("</log>").append(System.lineSeparator());

        return sb.toString();

    }
}
