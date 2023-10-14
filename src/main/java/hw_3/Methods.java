package hw_3;

public interface Methods<T, K, M> {

    public void addData(T id, K name, M tel);
    public void deleteData(T id);
    public void getData(T id);
}
