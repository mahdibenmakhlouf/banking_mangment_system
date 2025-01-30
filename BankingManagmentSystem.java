import java.util.ArrayList;
import java.util.Scanner;

public class BankingManagmentSystem {
    public static void main(String[] args) {
        Admin admin = new Admin();
        String whatdoyouwanttobe;
        String[] nameadmin = { "" };
        String[] passwordadmin = { "" };
        String whatyouwanttodoasanadmin;
        String nameuser;
        String passworduser;
        String whatyouwanttodoasauser;
        ArrayList<Account> accountList = new ArrayList<Account>();
        ArrayList<Operation> operationList = new ArrayList<Operation>();
        int i;
        int idAccount;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("what do you want to be admin or user or you want to exit:");
            whatdoyouwanttobe = scanner.nextLine();
            if (whatdoyouwanttobe.equals("exit")) {
                break;
            } else if (whatdoyouwanttobe.equals("admin")) {
                // login
                if (admin.login(nameadmin[0], passwordadmin[0]) == false
                        || (nameadmin[0].equals("") && passwordadmin[0].equals(""))) {
                    System.out.println("name : ");
                    nameadmin[0] = scanner.nextLine();
                    System.out.println("password : ");
                    passwordadmin[0] = scanner.nextLine();
                }
                while (admin.login(nameadmin[0], passwordadmin[0]) == true) {

                    System.out.println(
                            "what you whant to be as an admin : logout or add account or add operation or view balence or delete account or delete operation or exit :");
                    whatyouwanttodoasanadmin = scanner.nextLine();
                    if (whatyouwanttodoasanadmin.equals("exit")) {
                        break;
                    } else if (whatyouwanttodoasanadmin.equals("logout")) {
                        admin.logout(nameadmin, passwordadmin);
                    } else if (whatyouwanttodoasanadmin.equals("add account")) {
                        admin.addAcount(accountList);
                    } else if (whatyouwanttodoasanadmin.equals("add operation")) {
                        admin.addOperation(accountList, operationList);
                    } else if (whatyouwanttodoasanadmin.equals("view balance")) {
                        admin.viewBalance(accountList);
                    } else if (whatyouwanttodoasanadmin.equals("delete account")) {
                        admin.deleteAccount(accountList);
                    } else if (whatyouwanttodoasanadmin.equals("delete operation")) {
                        admin.deleteOperation(operationList);
                    }

                }

            } else if (whatdoyouwanttobe.equals("user")) {
                System.out.println("name : ");
                nameuser = scanner.nextLine();
                System.out.println("password : ");
                passworduser = scanner.nextLine();
                System.out.println("what's your id accound : ");
                idAccount = scanner.nextInt();
                scanner.nextLine();
                for (i = 0; i < accountList.size(); i++) {
                    if (accountList.get(i).firstName.equals(nameuser)
                            && accountList.get(i).GetPassword().equals(passworduser)
                            && (accountList.get(i)).GetId() == idAccount) {
                        while (true) {
                            System.out.println(
                                    "what you want to do : view balance or view pi or modify pi or list operations or exit : ");
                            whatyouwanttodoasauser = scanner.nextLine();
                            if (whatyouwanttodoasauser.equals("view balance")) {
                                User.viewBalence(accountList.get(i));
                            } else if (whatyouwanttodoasauser.equals("view pi")) {
                                User.viewPersonnelInformation(accountList.get(i));
                            } else if (whatyouwanttodoasauser.equals("modify pi")) {
                                User.modifyPersonnelInformation(accountList.get(i));
                            } else if (whatyouwanttodoasauser.equals("list operations")) {
                                User.listOperations(operationList, idAccount);
                            } else if (whatyouwanttodoasauser.equals("exit")) {
                                break;
                            } else
                                System.out.println("option not found");
                        }
                    }
                    if (i + 1 == accountList.size()) {
                        System.out.println("account not found");
                    }
                }

            } else
                System.out.println("option not found");
        }
        System.out.println("end of opertion");
    }
}
