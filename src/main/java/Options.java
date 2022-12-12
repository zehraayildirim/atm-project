import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account {

    Scanner scan = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer,Integer> accountNoPin = new HashMap<Integer,Integer>();

    public void checkingOperations(){
        do{
            System.out.println("Select option:");
            System.out.println("1:View Balance");
            System.out.println("2:Withdraw");
            System.out.println("3:Deposit");
            System.out.println("4:Exit");

            int option = scan.nextInt();
            if(option==4){
                break;
            }
            switch(option){
                case 1:
                    System.out.println("Your checking account balance is " + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    if(getCheckingBalance()>0) {
                        getCheckingWithdraw();
                    }else{
                        System.out.println("When the balance is 0, it is impossible to withdraw.");
                        System.out.println("You need to deposit first...");
                    }
                    break;
                case 3:
                    getDepositChecking();
                    break;
                default:
                    System.out.println("Invalid option, please select 1, 2, 3 or 4");
            }
        }while(true);
    }

    public void savingOperations(){
        do{
            System.out.println("Select option:");
            System.out.println("1:View Balance");
            System.out.println("2:Withdraw");
            System.out.println("3:Deposit");
            System.out.println("4:Exit");

            int option = scan.nextInt();
            if(option==4){
                break;
            }
            switch(option){
                case 1:
                    System.out.println("Your saving account balance is " + moneyFormat.format(getSavingBalance()));
                    break;
                case 2:
                    if(getSavingBalance()>0) {
                        getSavingWithdraw();
                    }else{
                        System.out.println("When the balance is 0, it is impossible to withdraw.");
                        System.out.println("You need to deposit first...");
                    }
                    break;
                case 3:
                    getDepositSaving();
                    break;
                default:
                    System.out.println("Invalid option, please select 1, 2, 3 or 4");
            }
        }while(true);
    }

    public void selectAccount(){
        do {
            System.out.println("Select option:");
            System.out.println("1:Checking Account Operations");
            System.out.println("2:Saving Account Operations");
            System.out.println("3:Exit");
            int option = scan.nextInt();
            if (option == 3) {
                System.out.println("Thanks, see you soon...");
                break;
            }else if(option == 1){
                checkingOperations();
            }else if(option == 2){
                savingOperations();
            }else{
                System.out.println("Invalid option, please select 1, 2 or 3");
            }
        }while(true);
    }
    public void login(){
        accountNoPin.put(12345,1234);
        accountNoPin.put(23456,2345);
        accountNoPin.put(34567,3456);
        accountNoPin.put(45678,4567);
        accountNoPin.put(56789,5678);

        System.out.println("Hi, Welcome to ATM...");

    do {
        System.out.println("Enter Account Number");
        setAccountNumber(scan.nextInt());

        System.out.println("Enter Pin Number");
        setPinNumber(scan.nextInt());
        int count = 0;
        for (Map.Entry<Integer, Integer> w : accountNoPin.entrySet()) {
            if (w.getKey() == getAccountNumber() && w.getValue() == getPinNumber()) {
                selectAccount();
            } else {
                count++;
            }
        }
        if (count == accountNoPin.size()) {
            System.out.println("Account number or pin number or both are not matching...");
            System.out.println("Press any integer to try again or 'Q' to quit...");
            String exit = scan.next().toLowerCase();
            if (exit.equals("q")) {
                break;
            }
        }
    }while(true);


    }



















}









