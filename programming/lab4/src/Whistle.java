
public class Whistle extends Weapon {
    public Whistle(String color, String material){
        super(color, material, Attack.PSYCHOLOGICAL, "�������");
    }

    @Override
    public void damage(Object whom) {
        if (!(whom instanceof Human) & !(whom instanceof Thing)){
            System.out.println("��� ������ ���������");
        }
        System.out.println("������� ������� � �������������� �����");
        if (whom instanceof Human whoHuman) {
            whoHuman.takeDamage(true);
        } else if ((whom instanceof Thing whoThing) ) {
            whoThing.takeDamage(true);
        }
    }
}
