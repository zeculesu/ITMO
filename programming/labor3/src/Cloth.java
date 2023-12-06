import java.util.Objects;

public class Cloth extends Thing {
    private Human putOnBy;
    private TypeCloth typeCloth;

    public Cloth(String color, String material, TypeCloth name){
        this.setColor(color);
        this.setMaterial(material);
        this.setName(name.name());
        this.typeCloth = name;
        System.out.println("Одежда <" + name + "> появилась в истории");
    }

    @Override
    public String toString() {
        String putOnBy = this.getPutOnBy() == null ? "null" : this.getPutOnBy().getName();
        String takenBy = this.getTakenBy() == null ? "null" : this.getTakenBy().getName();
        String movedBy = this.getMovedBy() == null ? "null" : this.getMovedBy().getName();
        return String.format("<Cloth name=%s color=%s material=%s putOnBy=%s takenBy=%s movedBy=%s>", this.getName(), this.getColor(), this.getMaterial(), putOnBy, takenBy, movedBy);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (!(this.getClass().isInstance(other))) return false;
        Cloth otherCloth = (Cloth) other;
        if (!(this.getColor().equals(otherCloth.getColor()))) return false;
        if (!(this.getMaterial().equals(otherCloth.getMaterial()))) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getColor(), this.getMaterial());
    }


    public Human getPutOnBy() {
        return this.putOnBy;
    }

    public void setPutOnBy(Human putOnBy) {
        this.putOnBy = putOnBy;
    }

    public TypeCloth getTypeCloth(){
        return this.typeCloth;
    }

    public void setTypeCloth(TypeCloth typeCloth){
        this.typeCloth = typeCloth;
    }
}
