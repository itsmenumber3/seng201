package logs;

public class Log {
    private String log;

    public Log(String inputLog) {
        this.setLog(inputLog);
    }

    public void setLog(String inputLog) {
        this.log = inputLog;
    }

    public String getLog() {
        return this.log;
    }

}
