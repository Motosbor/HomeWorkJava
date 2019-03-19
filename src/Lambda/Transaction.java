package Lambda;

public interface Transaction {
    public void operate(Account acc1, Account acc2, int sum);
}
