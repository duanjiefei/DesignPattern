package ThreadTest;

public class Bank {

    private int money = 1000;

    public synchronized int getMoney(int number){
        if (number < 0){
            return -1;
        }
        else if (number > money){
            return -2;
        }
        else if (money < 0) {
            return -3;
        }
        else{
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            money -= number;

            System.out.println("Left Money: " + money);
            return number;

        }
    }
}
