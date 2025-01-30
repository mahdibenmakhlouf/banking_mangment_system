
public class Account extends User {
    private String password;
    private int idAccount;
    private float balance;

    public Account(int idAccount, String password, float balance, String firstName, String lastName, String cin) {
        super(firstName, lastName, cin);
        this.password = password;
        this.balance = balance;
        this.idAccount = idAccount;
    }

    public float GetBalance() {
        return balance;
    }

    public int GetId() {
        return idAccount;
    }

    public String GetPassword() {
        return password;
    }

    public void SetBalancePlus(float money) {
        balance = balance + money;
    }

    public void SetBalanceMines(float money) {
        balance = balance - money;
    }

}
