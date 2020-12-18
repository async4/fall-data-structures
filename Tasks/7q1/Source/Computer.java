public class Computer implements Comparable<Computer> {
   
   private String name;

   private float cpu;
   private int ram;
   private int ssd;

   public Computer(String name, float cpu, int ram, int ssd) {
      this.name = name;
      this.cpu = cpu;
      this.ram = ram;
      this.ssd = ssd;
   }

   public String getName() {
      return this.name;
   }

   public float getCpu() {
      return this.cpu;
   }

   public int getRam() {
      return this.ram;
   }

   public int getSsd() {
      return this.ssd;
   }

   @Override
   public int compareTo(Computer comp) {

      if (this.cpu == comp.getCpu()) {
         if (this.ram == comp.getRam()) {
            if (this.ssd == comp.getSsd()) {
               return 0;
            } else {
               if (this.ssd < comp.getSsd()) {
                  return 1;
               } else {
                  return 0;
               }
            }
         } else {
            if (this.ram < comp.getRam()) {
               return 1;
            } else {
               return 0;
            }
         }
      } else {

         if (this.cpu < comp.getCpu()) {
            return 1;
         } else {
            return 0;
         }
      }
   }

   @Override
   public String toString() {
      String cpu_str = String.format("CPU: %.1f", this.cpu);
      String ram_str = String.format("RAM: %d", this.ram);
      String ssd_str = String.format("SSD: %d", this.ssd);

      return String.format("(%s)\n%s\n%s\n%s", this.name, cpu_str, ram_str, ssd_str);
   }
}
