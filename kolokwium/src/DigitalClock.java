public class DigitalClock extends Clock{
    private TimeType timeType;

    public enum TimeType {
        FULL,
        HALF
    }

    public DigitalClock(TimeType timeType, City city) {
        super(city);
        this.timeType = timeType;
    }

    @Override
    public String toString() {
        if (this.timeType == TimeType.FULL) {
            return super.toString();
        }

        if (this.hours >= 12)
            return String.format("%d:%02d:%02d PM", this.hours - 12, this.minutes, this.seconds);
        else
            return String.format("%d:%02d:%02d AM", this.hours, this.minutes, this.seconds);
    }
}
