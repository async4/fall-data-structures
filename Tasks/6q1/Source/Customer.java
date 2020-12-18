public class Customer {

   private final Integer id;
   private Integer remaining;

   public Customer(Integer id, Integer remaining) {
      this.id = id;
      this.remaining = remaining;
   }

   public Integer getId() {
      return this.id;
   }

   public Integer getRemaining() {
      return this.remaining;
   }

   public void decreaseRemaining() {
      this.remaining--;
   }
   
}
