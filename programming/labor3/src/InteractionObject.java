public abstract class InteractionObject {

    protected Human takenBy;
    protected Human movedBy;
    public abstract Human getTakenBy();
    public abstract void setTakenBy(Human by);

    public abstract Human getMovedBy();
    public abstract void setMovedBy(Human by);
}
