package scheduleApp.entity.enums;

public enum LessonType {
    LECTURE("Лекція"),
    PRACTICE("Практика"),
    SEMINAR("Семінар"),
    LAB("Лабораторна робота");

    private final String displayName;

    private LessonType(String s) {
        displayName = s;
    }

    public String getDisplayName() {
        return displayName;
    }

}
