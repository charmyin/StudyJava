package com.charmyin.practice.advantage.threads;


import java.util.concurrent.locks.*;

/**
   This program shows how multiple threads can safely access a data structure.
*/
public class SynchBankTest1
{
   public static void main(String[] args)
   {
      Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
      int i;
      for (i = 0; i < NACCOUNTS; i++)
      {
         TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
         Thread t = new Thread(r);
         t.start();
      }
      TransferRunnable rs = new TransferRunnable(b, 1, 123);
      Thread ts = new Thread(rs);
      ts.start();
      System.out.println("hello ended ");
      
     /* SignalAllRunnable sar = new SignalAllRunnable(b);
      Thread t = new Thread(sar);
      t.start();*/
      
   }

   public static final int NACCOUNTS = 10;
   public static final double INITIAL_BALANCE = 2000;
}

/**
   A bank with a number of bank accounts.
*/
class Bank
{
	public static int k = 0;
   /**
      Constructs the bank.
      @param n the number of accounts
      @param initialBalance the initial balance
      for each account
   */
   public Bank(int n, double initialBalance)
   {
      accounts = new double[n];
      for (int i = 0; i < accounts.length; i++)
         accounts[i] = 1000;
      bankLock = new ReentrantLock();
      sufficientFunds = bankLock.newCondition();
   }

   /**
      Transfers money from one account to another.
      @param from the account to transfer from
      @param to the account to transfer to
      @param amount the amount to transfer
   */
   public void transfer(int from, int to, double amount)
      throws InterruptedException
   {
	  
	   /*if(amount==123){
	    	  System.out.println(123);
	    	  Thread.currentThread().sleep(3000);
	    	  sufficientFunds.signalAll();
	    	  return;
	      }*/
	   
      bankLock.lock();
      
      
      try
      {
         while (accounts[from] < amount){
        	 k++;
        	 System.out.println(Thread.currentThread()+" thread before await-----------------------"+k);
        	 sufficientFunds.await();
        	 System.out.println(Thread.currentThread()+" thread after await-----------------------");
         }
            
        //  System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        // System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        // System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        System.out.println(sufficientFunds); 
        sufficientFunds.signalAll();
         
         /*if(k==9){
        	 
        	 sufficientFunds.signalAll();
        	 return;
         }*/
         //;
         
        // System.out.println("sygnalall-------------------"+k);
        
      }
      finally
      {
         bankLock.unlock();
      }
   }

    public void signalAlll() {
    	try{
    		 System.out.println("--------------"+sufficientFunds); 
    		   sufficientFunds.signalAll();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
      
	}
   
   /**
      Gets the sum of all account balances.
      @return the total balance
   */
   public double getTotalBalance()
   {
      bankLock.lock();
      try
      {
         double sum = 0;

         for (double a : accounts)
            sum += a;

         return sum;
      }
      finally
      {
         bankLock.unlock();
      }
   }

   /**
      Gets the number of accounts in the bank.
      @return the number of accounts
   */
   public int size()
   {
      return accounts.length;
   }

   private final double[] accounts;
   private Lock bankLock;
   private Condition sufficientFunds;

}

/**
   A runnable that transfers money from an account to other
   accounts in a bank.
*/
class TransferRunnable implements Runnable
{
   /**
      Constructs a transfer runnable.
      @param b the bank between whose account money is transferred
      @param from the account to transfer money from
      @param max the maximum amount of money in each transfer
   */
   public TransferRunnable(Bank b, int from, double max)
   {
      bank = b;
      fromAccount = from;
      maxAmount = max;
   }

   public void run()
   {
      try
      {
         while (true)
         {
            int toAccount = (int) (bank.size() * Math.random());
            double amount = maxAmount * Math.random();
            if(maxAmount==123){
            	bank.transfer(fromAccount, toAccount, 123);
            	return;
            }
            bank.transfer(fromAccount, toAccount, amount);
            Thread.sleep((int) (DELAY * Math.random()));
         }
      }
      catch (InterruptedException e) {}
   }

   private Bank bank;
   private int fromAccount;
   private double maxAmount;
   private int DELAY = 10;
}


/**
A runnable that test signalAll method of condition
*/
class SignalAllRunnable implements Runnable
{
/**
   Constructs a transfer runnable.
   @param b the bank between whose account money is transferred
   @param from the account to transfer money from
   @param max the maximum amount of money in each transfer
*/
public SignalAllRunnable(Bank b)
{
   bank = b;
}

public void run()
{
   try
   {
         Thread.currentThread().sleep(2000);
         bank.signalAlll();
         return;
   }
   catch (InterruptedException e) {}
}

private Bank bank;
}
