public class Weapon implements Thing {
    private String color;
    private String material;


    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setMaterial(String material) {
        this.material = material;
    }
}
