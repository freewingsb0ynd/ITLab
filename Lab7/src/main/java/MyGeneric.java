public class MyGeneric<T>  {
    private T tObject;

    public MyGeneric(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        this.tObject = (T) tClass.newInstance();
    }

    public T getTObject() {
        return this.tObject;
    }


}
