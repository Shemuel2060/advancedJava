package SEconcepts.objectsdesign;

public interface Publisher {
    public void subscribe(Subscriber subscriber);
    public void unsubscribe(Subscriber subscriber);
}
