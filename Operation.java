public class Operation {
    private String typeOfOperation;
    private float money;
    private int idAccount;

    public Operation(String typeOfOperation, float money, int idAccount) {
        this.typeOfOperation = typeOfOperation;
        this.money = money;
        this.idAccount = idAccount;
    }

    public int GetId() {
        return idAccount;
    }

    public String GetType() {
        return typeOfOperation;
    }

    public float GetMoney() {
        return money;
    }
}