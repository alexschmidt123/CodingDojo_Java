public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount BankAccount1 = new BankAccount();
        BankAccount1.deposit(1000.0D,true);
        BankAccount1.deposit(25000.0D,false);
        System.out.println(BankAccount1.getTotal());
    }
}
