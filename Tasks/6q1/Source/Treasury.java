import java.util.Arrays;


public class Treasury {

   private final Integer _id;
   private final Queue _customers;
   private Customer _current_customer;
   
   public Treasury(Integer id) {
      this._id = id;
      this._customers = new Queue();
      this._current_customer = this._customers.front();
   }

   public boolean add(Customer customer) {
      return this._customers.enqueue(customer);
   }

   public void decrease() {
      Customer current = this.getCurrentCustomer();

      if (current != null) {
         current.decreaseRemaining();
         
         if (current.getRemaining() <= 0) {
            this.remove();
            this.setCurrentCustomer();
         }
      }
   }

   public boolean remove() {
      return this._customers.dequeue();
   }
   
   // Getters
   public Integer getId() {
      return this._id;
   }

   public Queue getCustomers() {
      return this._customers;
   }

   public Customer getCurrentCustomer() {
      return this._customers.front();
   }

   public Integer getWaitingCustomers() {
      if (!this._customers.empty())
         return this._customers.getSize() -1;
      return 0;
   }

   // Setters
   private boolean setCurrentCustomer() {
      this._current_customer = this._customers.front();
      
      if (this._current_customer != null)
         return true;
      return false;
   }
   
   @Override
   public String toString() {
      String result = "";
      String COLOR;

      for (Customer customer : this._customers.getData()) {
         if (customer != null) {
            COLOR = (customer == this._customers.front()) ? Controller.RED : Controller.BLACK;
            result += COLOR + "-------------------\n" + "| id: " + customer.getId() + " ( "+ customer.getRemaining() + " )   |\n-------------------\n" + Controller.RESET;
         }
      }

      this.decrease();
      return result;  
   }
}
