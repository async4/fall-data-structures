package Common.Blood;

public enum BloodType {
   ARHP {
      @Override
      public String toString() {
         return "A Rh+";
      }
   },
   ARHN {
      @Override
      public String toString() {
         return "A Rh-";
      }
   },
   BRHP {
      @Override
      public String toString() {
         return "B Rh+";
      }
   },
   BRHN {
      @Override
      public String toString() {
         return "B Rh-";
      }
   },
   ABRHP {
      @Override
      public String toString() {
         return "AB Rh+";
      }
   },
   ABRHN {
      @Override
      public String toString() {
         return "AB Rh-";
      }
   },
   ZRHP {
      @Override
      public String toString() {
         return "0 Rh+";
      }
   },
   ZRHN {
      @Override
      public String toString() {
         return "0 Rh-";
      }
   },

}