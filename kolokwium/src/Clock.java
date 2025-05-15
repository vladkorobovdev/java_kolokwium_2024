import java.time.LocalTime;

public abstract class Clock {
    protected int hours;
    protected int minutes;
    protected int seconds;

    public Clock() {

    }

    public void setCurrentTime() {
        this.hours = LocalTime.now().getHour();
        this.minutes = LocalTime.now().getMinute();
        this.seconds = LocalTime.now().getSecond();
    }

    public void setTime(int hours, int minutes, int seconds) {
        if (hours >= 24 || hours < 0) {
            throw new IllegalArgumentException("Hours can't be greater or equal 24 and less than 0");
        }
        if (minutes >= 60 || minutes < 0) {
            throw new IllegalArgumentException("Minutes can't be greater or equal 60 and less than 0");
        }
        if (seconds >= 60 || seconds < 0) {
            throw new IllegalArgumentException("Seconds can't be greater or equal 60 and less than 0");
        }

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }
}
