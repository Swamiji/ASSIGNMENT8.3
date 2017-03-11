
public class withdrawaccount implements Runnable {
	private bankaccount acc;
    private int amount;

    public withdrawaccount(){
        acc = null;
        amount = 0;
    }

    public withdrawaccount(bankaccount acc,int amount){
        this.acc = acc;
        this.amount = amount;
    }
	public void run() {
		int w; 

        for(int i =0; i<20; i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Balance before "+Thread.currentThread().getName()+" withdrawl: "+acc.getBalance());
            w = acc.withdraw(amount);
            System.out.println("Balance after "+Thread.currentThread().getName()+" withdrawl: "+acc.getBalance());
            System.out.println("amount with drawn by: "+Thread.currentThread().getName()+" "+w);

        }

    }

public static void main(String args[]){
	 bankaccount b = new bankaccount(1000);
     withdrawaccount w = new withdrawaccount(b,10);
     Thread wt1 = new Thread(w);
     wt1.setName("T1");

     Thread wt2 = new Thread(w);
     wt2.setName("T2");

     wt1.start();
     wt2.start();
 
		
	}
}
