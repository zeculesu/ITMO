public class Thing extends InteractionObject {

    private String name;
    private String color;
    private String material;

    private boolean damaged;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean getDamaged() {
        return this.damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    @Override
    public Human getTakenBy() {
        return this.takenBy;
    }

    @Override
    public void setTakenBy(Human by) {
        this.takenBy = by;
    }

    @Override
    public Human getMovedBy() {
        return this.movedBy;
    }

    @Override
    public void setMovedBy(Human by) {
        this.movedBy = by;
    }
}