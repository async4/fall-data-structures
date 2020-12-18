public class Car {
   private final String brand;
   private final int model;
   private final int year;

   public Car(String brand, int model, int year) {
      this.brand = brand;
      this.model = model;
      this.year = year;
   }
   
   @Override
   public String toString() {
      final String result = 
         "Brand: " + this.brand + " \n" +
         "Model: " + this.model + " \n" +
         "Year: "  + this.year  + " \n";

      return result;
   }
}
