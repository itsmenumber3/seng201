package logs;

import java.util.ArrayList;

public class Log {
    private final ArrayList<LogLine> logs = new ArrayList<>();

    public void writeLog(String inputLogTime, String inputLogSubject, String inputLogContent) {
        LogLine newLog = new LogLine(inputLogTime, inputLogSubject, inputLogContent);
        logs.add(newLog);
    }

    public ArrayList<LogLine> getLog() {
        return this.logs;
    }
}
