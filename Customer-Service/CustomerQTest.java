import java.util.*;

public class CustomerQTest{

  int numCustomerReps = 9;
  int msRepMinute = 10;
  ArrayList<Customer> finishedCustomers  = new ArrayList<Customer>();
  PriorityQueue<Customer> pq = new PriorityQueue<Customer>();

  CustomerQTest(){

    int wastedMinutes = 0;

    for (int i = 0; i < 480; i++){

      delay(msRepMinute);
      int rand = (int)(Math.random()*100+1);
      if (rand > 20)
        pq.add(new Customer(Math.random() <0.8?false:true));
      if (rand > 70)
        pq.add(new Customer(Math.random() <0.8?false:true));
      if (rand > 95)
        pq.add(new Customer(Math.random() <0.8?false:true));
         

      for (int j = 0; j < numCustomerReps; j++)
        if (Math.random() < 0.2){
          if (pq.isEmpty())
            wastedMinutes++;
          else{
            Customer c = pq.poll();
            c.setHoldTime();
            finishedCustomers.add(c);            
          }
        }

        if(i%60 == 0)
          System.out.println(i/60+" hours");

    }
    int overtime = 1;
    while (!pq.isEmpty()){
      delay(msRepMinute);
      for (int j = 0; j < numCustomerReps; j++)
        if (Math.random() < 0.2){
          if (pq.isEmpty()) //Queue already clear, time wasted
            wastedMinutes++;
          else{
            Customer c = pq.poll();    //remove from Queue move to ArrayList
            c.setHoldTime();
            finishedCustomers.add(c);            
          }
        }
        overtime++;
    }

    
    System.out.println("Average Hold Time (non priority) = "+(double)Math.round(aveHoldTime(false)*10)/(10*msRepMinute)+" mins");
    System.out.println("Average Hold Time (priority) = "+(double)Math.round(aveHoldTime(true)*10)/(10*msRepMinute)+" mins");
    System.out.println("Max Hold Time (non priority) = "+(double)Math.round(maxHoldTime(false)*10) / (10*msRepMinute)+" mins");
    System.out.println("Max Hold Time (priority) = "+(double)Math.round(maxHoldTime(true)*10) / (10*msRepMinute)+" mins");
    System.out.println("Wasted Minutes = "+wastedMinutes+" mins");
    System.out.println("Minutes of overtime: "+overtime +" mins");

    


  }

  public double aveHoldTime(boolean priority){
    double sum = 0;
    int count = 0;
    for (Customer c : finishedCustomers)
      if (priority == c.getPriority() ){
        sum+= c.getHoldTime();
        count++;
      }
    return sum/count;
  }

  public double maxHoldTime(boolean priority){
    double maxHold = 0;
    for (Customer c : finishedCustomers){
      if (priority == c.getPriority() )
        if (c.getHoldTime() > maxHold)
          maxHold = c.getHoldTime();
        
    }
    return maxHold;
  }

  public void delay(long ms){
    try {
      // thread to sleep for ms milliseconds
      Thread.sleep(ms);
    } catch (Exception e) {
      System.out.println(e);
    }
  }



}