package model;

public interface Operable<T> {

    public boolean equalsZero();
    public boolean equalsOne();

    public T sum(T value);
    public T sub(T value);

    public T mult(T value);
    public T div(T value);

    public T one();
    public T zero();

}
