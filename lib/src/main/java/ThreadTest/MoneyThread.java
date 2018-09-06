package ThreadTest;

public class MoneyThread  extends  Thread{
    private Bank bank;
    private String name;

    public MoneyThread(Bank bank ,String name){
        this.name = name;
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println("thread name =="+ name+ ">>"+bank.getMoney(800));
    }
}
