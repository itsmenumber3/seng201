public class LocationBeacon {
    int hours;
    int minutes;
    int distance;

    public void heartBeat(int startHour, int startMinute, int startDistance, int speed, int duration) {
        
        for (int minute = startMinute; minute <= duration; minute = minute + 10) {
            System.out.println("[" +  startHour + ":" + minute + "]" + " Starman is <distance>km away from Earth");
            duration = duration - 10;
            if (minute >= 60) {
                startHour++;
                minute = 0;
            }
            
        }    

    }

    public static void main(String[] args) {
        LocationBeacon beacon = new LocationBeacon();	
        beacon.heartBeat(14, 31, 300000, 60000, 60);
    }
}
