// checked ����������
public class DamageException extends Exception {

    Object whom;
    Object chem;

    public DamageException(Object whom, Object chem) {
        super("���� ���� ");
        this.whom = whom;
        this.chem = chem;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + this.whom + " � ������� " + this.chem;
    }
}