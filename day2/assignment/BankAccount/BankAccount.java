import java.util.Random;
public class BankAccount {
    private Double checking;
    private Double saving;
    private long accountID;
    private static Double bankCapital;
    private static Integer numberOfAccount =0;
    private static Random random = new Random();
    
    public BankAccount(){
        BankAccount.numberOfAccount++;
        accountID = generateID();
        checking =0.00D;
        saving  = 0.00D;
    }
    public Long generateID(){
        String id ="";
        for (int i=0; i<10; i++){
            id += random.nextInt(9);
        }
        return Long.parseLong(id);
    }
    public Double getChecking(){
        return checking;
    }
    public Double setChecking(){
        return checking;
    }
    public Double getSaving(){
        return saving;
    }
    public Double setSaving(){
        return saving;
    }
    public Double getTotal(){
        return saving + checking;
    }
    public void deposit(Double money, Boolean isChecking){
        if (isChecking){
            checking += money;
        }else{
            saving += money;
        }
    }
    public Double withdraw(Double money, Boolean isChecking){
        if (isChecking){
            if (checking < money){
                return 0.00;
            }else{
                checking -= money;
            }
        }else{
            if (saving < money){
                return 0.00;
            }else{
                saving -= money;
            }
        }
        return money;
    }


}