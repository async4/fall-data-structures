import java.util.concurrent.ThreadLocalRandom;


public class Machine {
   Treasury[] treasuries;

   public Machine(Treasury[] treasuries) {
      this.treasuries = treasuries;
   }

   public Treasury find() {
      Integer min_size = Integer.MAX_VALUE;
      Treasury result = null;

      for (Treasury treasury : this.treasuries) {
         Integer temp = treasury.getCustomers().getSize();

         if (temp <= min_size)  {
            min_size = temp;
            result = treasury;
         }
      }
      
      return (result != null) ? result : null; 

   }

   private Integer generate_id(Treasury treasury) {
      Customer customer = treasury.getCustomers().front();

      switch (treasury.getId()) {
         case 1:
            if (customer == null)
               return 100;

         case 2:
            if (customer == null)
               return 200;

         case 3:
            if (customer == null)
               return 300;

         case 4:
            if (customer == null)
               return 400;

      };

      return ThreadLocalRandom.current().nextInt(
                  customer.getId()+1, customer.getId()+6);

   }

   private Integer generate_remaining() {
      return ThreadLocalRandom.current().nextInt(10, 59);  
   }


   public boolean generate_ticket(Treasury treasury) {
      Integer id = generate_id(treasury);
      Integer remaining = generate_remaining();

      Customer temp_customer = new Customer(id, remaining);
      if (treasury.add(temp_customer)) 
         return true;
      return false;
   }

}
