import kotlin.jvm.internal.Intrinsics;

import java.util.Objects;

public class Human {
    private String name;
    private Mood mood;
    private int height;

    public Human() {
        name = "Коротышка";
        mood = Mood.NORMAL;
        height = 14;
    }

    public Human(String name, Mood mood, int height) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mood, "mood");
        this.name = name;
        this.mood = mood;
        this.height = height;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof Human otherHuman)) return false;
        if (!(this.name.equals(otherHuman.name))) return false;
        if (!(this.mood.equals(otherHuman.mood))) return false;
        if (this.height != otherHuman.height) return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("<Human name='%s' mood=%s height=%d>", this.name, this.mood, this.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.mood, this.height);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Mood getMood() {
        return this.mood;
    }

    public void setMood(Mood newMood) {
        this.mood = newMood;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
}
