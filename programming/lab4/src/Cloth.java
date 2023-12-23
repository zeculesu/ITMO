import java.util.Objects;

public class Cloth extends Thing {
    private TypeCloth typeCloth;

    public Cloth(String color, String material, TypeCloth name){
        this.setColor(color);
        this.setMaterial(material);
        this.setName(name.name());
        this.takeDamage(false);
        this.typeCloth = name;
        System.out.println("Одежда <" + name + "> появилась в истории");
    }

    @Override
    public String toString() {
        return String.format("<Cloth name=%s color=%s material=%s>", this.name(), this.getColor(), this.getMaterial());
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


    public TypeCloth getTypeCloth(){
        return this.typeCloth;
    }

    public void setTypeCloth(TypeCloth typeCloth){
        this.typeCloth = typeCloth;
    }
}
