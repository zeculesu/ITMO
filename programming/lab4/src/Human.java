import java.util.ArrayList;
import java.util.Objects;

public class Human implements Namable, Takeable, Damagable{
    private String name;
    private Mood mood;
    private int height;

    private boolean damaged;

    private ArrayList<Thing> inventory = new ArrayList<>();


    public Human(String name, Mood mood, int height) {
        this.name = name;
        this.mood = mood;
        this.height = height;
        System.out.println("Человек <" + name + "> появился в истории");
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

    public void setName(String newName) {
        this.name = newName;
    }

    public Mood getMood() {
        return this.mood;
    }

    public void setMood(Mood newMood) {
        System.out.println(this.name() + " сменил настроение с " + this.getMood() + " на " + newMood);
        this.mood = newMood;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    public ArrayList<Thing> getInventory() {
        return this.inventory;
    }

    public boolean getDamaged() {
        return this.damaged;
    }

    @Override
    public void takeDamage(boolean damaged) {
        this.damaged = damaged;
    }

    @Override
    public String name() {
        return this.name;
    }

   public void doSomething(Action a){
        a.doIt(this);
    }
    public void doSomethingWithWhom(Action a, Namable whom){
        a.doIt(whom);
    }


    public void damage(Object whom, Weapon weapon) {
        if (whom instanceof Human){
            Human whomSb = (Human) whom;
            System.out.println(this.name() + " наносит урон человеку " + whomSb.name() + " с помощью " + weapon.name());
        }
        else{
            Thing whomSb = (Thing) whom;
            System.out.println(this.name() + " наносит урон предмету " + whomSb.name() + " с помощью " + weapon.name());
        }
        weapon.damage(whom);
    }

    @Override
    public void take(Thing obj) {
        this.inventory.add(obj);
        System.out.println(this.name() + " взял предмет " + obj.name());
    }

    public static class Thought{
        public static void think(String name, String about){
            System.out.println(name + " подумал о " + about);
        }
    }
}
