package scheduleApp;

public enum DayOfWeek {
    MONDAY(1, "Понеділок"),
    TUESDAY(2, "Вівторок"),
    WEDNESDAY(3, "Середа"),
    THURSDAY(4, "Четвер"),
    FRIDAY(5, "П'ятниця"),
    SATURDAY(6, "Субота");

    private final String displayName;
    private final int value;

    private DayOfWeek(int v, String s) {
        value = v; displayName = s;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }
}