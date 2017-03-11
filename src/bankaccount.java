
public class bankaccount {
	private volatile int balance;

    public bankaccount(int b){
        balance = b;
    }

    public bankaccount(){
        balance = 0;
    }


    synchronized public int getBalance(){
        return balance;
    }

    synchronized public int withdraw(int w)
    {
        int b = getBalance();
        if(w <= b){
            balance = balance-w;
            return w;
        }
        else
            return 0;
    }
}

