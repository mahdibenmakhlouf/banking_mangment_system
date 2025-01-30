import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    final String name = "system";
    final String password = "system123";
    private String firstName;
    private String lastName;
    private String cin;
    private String passwordAccount;
    private int idAccount;
    private float balance;
    private String typeOfOperation;
    private float money;
    Operation o;
    Account A;
    int i;
    Scanner scanner = new Scanner(System.in);

    public boolean login(String name, String password) {
        return ((this.name.equals(name) && this.password.equals(password)));
    }

    public void logout(String[] name, String[] password) {
        name[0] = "";
        password[0] = "";
    }

    public void addAcount(ArrayList<Account> list) {
        int k=0;
        System.out.println("add fistname : ");
        firstName = scanner.nextLine();
        System.out.println("add lastname : ");
        lastName = scanner.nextLine();
        System.out.println("add cin : ");
        cin = scanner.nextLine();
        System.out.println("add password accout : ");
        passwordAccount = scanner.nextLine();
        System.out.println("add id account : ");
        idAccount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("add balance : ");
        balance = scanner.nextFloat();
        scanner.nextLine();
        for(int i=0;i<list.size();i++){
            if(list.get(i).GetId()==idAccount)
                k++;
        }
        if(k==0){
        A = new Account(idAccount, passwordAccount, balance, firstName, lastName, cin);
        list.add(A);
        System.out.println("account added");
        }

    }

    public void addOperation(ArrayList<Account> list1, ArrayList<Operation> list2) {
        System.out.println("operation id account : ");
        idAccount = scanner.nextInt();
        scanner.nextLine();
        for (i = 0; i < list1.size(); i++) {
            if ((list1.get(i)).GetId() == idAccount) {
                System.out.println("what type of operation deposit or withdraw : ");
                typeOfOperation = scanner.nextLine();
                if (typeOfOperation.equals("deposit")) {
                    System.out.println("money that you want deposit : ");
                    money = scanner.nextFloat();
                    (list1.get(i)).SetBalancePlus(money);
                    o = new Operation("deposit", money, idAccount);
                    list2.add(o);

                } else if (typeOfOperation.equals("withdraw")) {
                    System.out.println("money that you want withdraw : ");
                    money = scanner.nextFloat();
                    (list1.get(i)).SetBalanceMines(money);
                    o = new Operation("withdraw", money, idAccount);
                    list2.add(o);

                }
                break;
            }
        }
        if (i == list1.size()) {
            System.out.println("id account not found");
        }
    }

    public void viewBalance(ArrayList<Account> list1) {
        System.out.println("view balance id account : ");
        idAccount = scanner.nextInt();
        scanner.nextLine();
        for (i = 0; i < list1.size(); i++) {
            if ((list1.get(i)).GetId() == idAccount) {
                System.out.println("the balance of " + idAccount + " = " + (list1.get(i)).GetBalance());
                break;
            }
        }
        if (i == list1.size()) {
            System.out.println("id account not found");
        }
    }

    public void deleteAccount(ArrayList<Account> list1) {
        System.out.println("delete id account : ");
        idAccount = scanner.nextInt();
        scanner.nextLine();
        for (i = 0; i < list1.size(); i++) {
            if ((list1.get(i)).GetId() == idAccount) {
                list1.remove(i);
                System.out.println("account have bein removed");
                break;
            }
        }
        if (i == list1.size()) {
            System.out.println("id account not found");
        }
    }

    public void deleteOperation(ArrayList<Operation> list1) {
        System.out.println("delete id account : ");
        idAccount = scanner.nextInt();
        scanner.nextLine();
        for (i = 0; i < list1.size(); i++) {
            if ((list1.get(i)).GetId() == idAccount) {
                list1.remove(i);
                System.out.println("operation have bein removed");
                break;
            }
        }
        if (i == list1.size()) {
            System.out.println("id account not found");
        }
    }
}