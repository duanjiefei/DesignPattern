package ThreadTest;

public class FetchMoneyTest {

    public static void main(String[] args){
        Bank bank = new Bank();
        MoneyThread mt1 =  new MoneyThread(bank,"mt1");
        MoneyThread mt2 =  new MoneyThread(bank,"mt2");
        mt1.start();
        mt2.start();

    }

}
