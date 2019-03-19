package Lambda;

public interface AccountOperation {

    boolean availableBalance();
    void put(int sum);
    void withdraw(int sum);
}
