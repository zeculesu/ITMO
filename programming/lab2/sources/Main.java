import pokemons.*;
import ru.ifmo.se.pokemon.*;


public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Mawile("Мавиль", 4);
        Pokemon p2 = new Bellsprout("Бильспраут", 1);
        Pokemon p3 = new Ariados("Аридос", 3);
        Pokemon p4 = new Spinarak("Спинарак", 2);
        Pokemon p5 = new Weepinbell("Вибинбил", 1);
        Pokemon p6 = new Victreebel("Виктор", 10);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addAlly(p4);
        b.addAlly(p5);
        b.addFoe(p6);
        b.go();
    }
}
