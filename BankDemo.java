import java.util.*;
interface s
{
    Scanner sc=new Scanner(System.in);
}
interface Account_Interface
{
    public double deposit(double d_money);
    public double withdraw(double w_money);
}
abstract class Account
{
    int account_id,customer_id;
}
class SavingAccount extends Account implements Account_Interface
{
    double balance;
    SavingAccount()
    {
        account_id=-1;
        customer_id=-1;
        balance=0;
    }
    SavingAccount(int account_id,int customer_id,double balance)
    {
        this.account_id=account_id;
        this.customer_id=customer_id;
        this.balance=balance;        
    }
    public double deposit(double d_money)
    {
        if(account_id==-1)
        {
            System.out.print("Account does not exist!!");
            return -1;
        }
        else
        {
            balance=balance+d_money;
            return balance;
        }
    }
    public double withdraw(double w_money)
    {
        if(account_id==-1)
        {
            System.out.print("Account does not exist!!");
            return -1;
        }
        else
        {
            if(w_money<=balance)
            {
                balance=balance-w_money;
                return balance;
            }
            else
            {
                System.out.print("Sufficient amount not present in the account. Please deposit INR "+(w_money-balance)+" to withdraw INR "+w_money+"\n");
                return -2;
            }
        }
    }
    void display()
    {
        System.out.println("Account ID: "+account_id);
        System.out.println("Customer ID: "+customer_id);
        System.out.println("Total amount available in your account: INR "+balance);
    }
}
class BankDemo implements s
{
    public static void main(String args[])
    {
        char wish='y';
        int n,account_id,customer_id,ac_id,choice;
        double d_money,w_money,balance;
        System.out.print("Enter the number of Saving accounts to be stored: ");
        n=sc.nextInt();
        sc.nextLine();
        SavingAccount objects[]=new SavingAccount[n];
        System.out.println("Enter the Savings Account details:-");
        for(int i=0;i<n;i++)
        {
            System.out.println("\nRecord "+(i+1));
            System.out.print("Enter the Account ID: ");
            account_id=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the Customer ID: ");
            customer_id=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the initial balance of your account: ");
            balance=sc.nextInt();
            sc.nextLine();
            objects[i]=new SavingAccount(account_id,customer_id,balance);
        }
        do
        {
            System.out.println("Choose any one from the following options:-");
            System.out.println("1.Deposit\n2.Withdraw\n3.Display\n4.Exit");
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                {
                    boolean flag=false;
                    System.out.print("Enter the account ID to deposit amount: ");
                    ac_id=sc.nextInt();
                    sc.nextLine();
                    for(int i=0;i<n;i++)
                    {
                        if(objects[i].account_id==ac_id)
                        {
                            flag=true;
                            System.out.print("Enter the amount to be deposited: ");
                            d_money=sc.nextDouble();
                            sc.nextLine();
                            objects[i].deposit(d_money);
                            System.out.println("The updated balance of your account is: INR "+objects[i].balance);
                            break;
                        }  
                    }
                    if(flag==false)
                        System.out.println("Savings account with Account ID "+ac_id+" not found!!");
                    break;
                }
                case 2:
                {
                    boolean flag=false;
                    double temp;
                    System.out.print("Enter the account ID to withdraw amount: ");
                    ac_id=sc.nextInt();
                    sc.nextLine();
                    for(int i=0;i<n;i++)
                    {
                        if(objects[i].account_id==ac_id)
                        {
                            flag=true;
                            System.out.print("Enter the amount to be withdrawn: ");
                            w_money=sc.nextDouble();
                            sc.nextLine();
                            temp=objects[i].withdraw(w_money);
                            if(temp!=-2)
                                System.out.println("\nThe updated balance of your account is: INR "+objects[i].balance);
                            break;
                        }
                    }
                    if(flag==false)
                        System.out.println("Savings account with Account ID "+ac_id+" not found!!");
                    break;    
                }
                case 3:
                {
                    boolean flag=false;
                    System.out.print("Enter the account ID to display account details: ");
                    ac_id=sc.nextInt();
                    sc.nextLine();
                    for(int i=0;i<n;i++)
                    {
                        if(objects[i].account_id==ac_id)
                        {
                            flag=true;
                            objects[i].display();
                            break;
                        }
                    }
                    if(flag==false)
                        System.out.println("Savings account with Account ID "+ac_id+" not found!!");
                    break;    
                }
                case 4:
                {
                    System.out.println("Thanks for using our program!!");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Enter the correct choice from the given options!!");
            }
            System.out.print("Do you want to continue? (Y/N): ");
            choice=sc.next().charAt(0);
        }while(wish=='y' || wish=='Y');
    }
}