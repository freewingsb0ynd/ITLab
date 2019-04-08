

public class ObjImpGenericI<G> implements IGeneric<G> {
    private G unitName;

    @Override
    public G doSomething() {
        return unitName;
    }

    public ObjImpGenericI(G unitName) {
        this.unitName = unitName;
    }
}
