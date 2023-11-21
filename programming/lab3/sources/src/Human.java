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
        this.name = name;
        this.mood = mood;
        this.height = height;
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
