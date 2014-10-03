package scheduleApp.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LessonType {
    LECTURE("Лекція"),
    PRACTICE("Практика"),
    SEMINAR("Семінар"),
    LAB("Лабораторна робота");

    private final String displayName;

    private LessonType(String s) {
        displayName = s;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

}
