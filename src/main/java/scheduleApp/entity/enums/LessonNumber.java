package scheduleApp.entity.enums;

public enum LessonNumber {
    N1(1, "1 (8:30 - 10:05)"),
    N2(2, "2 (10:25 - 12:00)"),
    N3(3, "3 (12:20 - 13:55)"),
    N4(4, "4 (14:15 - 15:50)"),
    N5(5, "5 (16:10 - 17:45)");

    private final String displayName;
    private final int value;

    private LessonNumber(int v, String s) {
        value = v; displayName = s;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }
}
