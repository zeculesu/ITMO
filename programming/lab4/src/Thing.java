public class Thing implements Namable, Damagable{

    private String name;
    private String color;
    private String material;

    private boolean damaged;

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setName(String newName) {
        this.name = newName;
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
}