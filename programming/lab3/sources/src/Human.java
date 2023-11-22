import kotlin.jvm.internal.Intrinsics;

import java.util.Objects;

public class Human implements Takeable {
    private String name;
    private Mood mood;
    private int height;
    private Human takenBy;

    public Human(String name, Mood mood, int height) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mood, "mood");
        this.name = name;
        this.mood = mood;
        this.height = height;
        this.takenBy = null;
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
        return String.format("<Human name='%s' mood=%s height=%d takenBy=%s>", this.name, this.mood, this.height, this.takenBy);
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

    @Override
    public Human getTakenBy() {
        return this.takenBy;
    }

    @Override
    public void setTakenBy(Human by) {
        this.takenBy = by;
    }
}
