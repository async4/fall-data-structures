import java.util.Scanner;
import java.io.IOException;

public class Controller {
   public static final String RESET = "\033[0m"; 
   public static final String BLACK = "\033[1;30m"; 
   public static final String RED = "\033[1;31m"; 

   private boolean _status;

   public final Machine kiosk;
   private Treasury empty_treasury;
   public Treasury[] treasuries = new Treasury[4];

   public Controller() {
      for (int i = 0; i < 4; i++)
         treasuries[i] = new Treasury(i+1);

      kiosk = new Machine(treasuries);

      this._status = true;
   }

   public void run() {
      while (this._status) {
         try {
            Thread.sleep(100);
            this.show();
         } catch (InterruptedException e) {
            this.kill();
            Thread.currentThread().interrupt();
         }

         new Thread(() -> {
            try {
               if (System.in.read() != 1) {
                  this.empty_treasury = this.kiosk.find();
                  this.kiosk.generate_ticket(this.empty_treasury);
                  this.show();
               }
            } catch (IOException e) {
               e.printStackTrace();
               this.kill();
            }
         }).start();
      }
   }

   private void show() {
      System.out.print("\033\143");

      for (int i = 3; i >= 0; i--) {
         System.out.println(Integer.toString(i+1) + ", Waiting " + this.treasuries[i].getWaitingCustomers() + " Customer \n" + this.treasuries[i]);
      }
      System.out.print(">>>");
   }

   public boolean status() {
      return this._status;
   }

   public void kill() {
      System.out.println("System killed");
      this._status = false;
   }
}
