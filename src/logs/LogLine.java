package logs;

import main.Role;

public class LogLine {
    public LogLine(String inputLogTime, String inputLogSubject, String inputLogContent) {
        this.setLogTime(inputLogTime);
        this.setLogSubject(inputLogSubject);
        this.setLogContent(inputLogContent);
    }
    private String logTime;

    public void setLogTime(String inputLogTime) {
        this.logTime = inputLogTime;
    }

    public String getLogTime() {
        return this.logTime;
    }

    private String logSubject;

    public void setLogSubject(String inputLogSubject) {
        this.logSubject = inputLogSubject;
    }

    public String getLogSubject() {
        return this.logSubject;
    }

    private String logContent;

    public void setLogContent(String inputLogContent) {
        this.logContent = inputLogContent;
    }

    public String getLogContent() {
        return this.logContent;
    }

    private Role logActor;

    public void setLogActor(Role inputLogActor) {
        this.logActor = inputLogActor;
    }

    public Role getLogActor() {
        return this.logActor;
    }

    private Role logActedUpon;

    public void setLogActedUpon(Role inputLogActedUpon) {
        this.logActedUpon = inputLogActedUpon;
    }

    public Role getLogActedUpon() {
        return this.logActedUpon;
    }


}
