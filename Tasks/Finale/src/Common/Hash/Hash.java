package Common.Hash;

import Common.Blood.BloodType;
import Common.Person.Person;

public class Hash {
   /*
   *    RASTGELE BIR NUMARA URETMEK ICIN TC KIMLIK NUMARASINDA KULLANILAN ALGORITMA KULLANILDI
   *
   *           1 2 3 4 5 6 7 8 9 10 11
   *           A B C D E F G H I J  K     --- 11 HANELI BIR TC KIMLIK NUMARASI
   *           * + * + * + * + *
   *
   *           * ILE ISARETLENMIS SAYILARIN TOPLAMI = A + C + E + G + I
   *           + ILE ISARETLENMIS SAYILARIN TOPLAMI = B + D + F + H
   *
   *           * ILE ISARETLENMIS SAYILARIN TOPLAMININ 7 KATINDAN, + ILE ISARETLENMIS OLAN SAYILAR CIKARILDIGINDA
   *           ELDE EDILEN SAYININ MOD 10 U BIRLER BASAMAGI EGER BU KIMLIK NUMARASININ 10.HANESINI VERIYORSA BU KIMLIK
   *           GERCEK BIR KIMLIK OLABILIR. (bkz: Person/IdControl.java)
   *           (bkz: https://seyler.eksisozluk.com/tc-kimlik-numaralarindaki-inanilmaz-algoritma)
   *
   *           (BU HASH ALGORITMASINDA ISE MOD 10 ALINMAMISTIR.)
   *
   *    ELDE EDILEN BU SAYI ILE KAN GRUPLARININ KATSAYILARI ILE VE EGER VARSA ACILIYET DURUMUNUN KATSAYISI
   *    ILE CARPILARAK FINAL KEY URETILMIS OLUR VE HEAPE AKTARIR.
   *
   *    KAN GRUPLARININ KATSAYILAR NEYE GORE BELIRLENDI:
   *        1) a-(0.12), b-(0.12), 0-(0.08), 0+(0.12) kan alicilar icinde onceliklilerdir.
   *           ORNEGIN A Rh- YE KAN VEREBILENLER:
   *               0 Rh- (0 Rh- TUM GRUPLARA KAN VEREBILDIGI ICIN -- 8 TANE GRUP -- 0.08 KATSAYISI VERILMISTIR.),
   *               A Rh- (A RH- 4 TANE GRUBA KAN VEREBILDIGI ICIN 0.04 KATSAYISI VERILMISTIR.)
   *               TOPLAMDA A Rh- ICIN 0.08 + 0.04 = 0.12 KATSAYISI TANIMLANMISTIR. EGER KISININ ACILIYET DEGISKENI
   *               TRUE ISE ELDE EDILEN KATSAYIDAN (0.12) DEN 0.05 DEGERI CIKARILIR. (0.05 RASTGELE VERILMISTIR.
   *               AMAC KATSAYIYI KUCULTEREK SAYIYI 0 A YAKLASTIRMAKTIR.)
   *
   *        2) ab+(0.27), ab-(0.18), a+(0.18), b+(0.18) kan alicilar icinde oncelikli degillerdir.
   *
   *        3) 0-(0.27), 0+(0.05), a-(0.09), b-(0.09)  kan verenler icinde onceliklilerdir.
   *           KAN VERENLERDE KATSAYILAR - ILE CARPILIP NEGATIF SAYI OLARAK HEAPE EKLENIR. CUNKU HEAP MIN HEAPDIR.
   *
   *        4) ab+(0.01), ab-(0.03), a+(0.03), b+(0.03) kan verenler icinde oncelikli degillerdir.
   */
   public static float key(Person p1) {
      float final_key;
      int oddSum = 0;
      int evenSum = 0;
      char[] charList = p1.getId().toCharArray();

      for (int i = 0; i <= 8; i+=2)
         oddSum += Integer.parseInt(String.valueOf(charList[i]));

      for (int i = 1; i < 9; i+=2)
         evenSum += Integer.parseInt(String.valueOf(charList[i]));

      float sum = Math.abs((oddSum * 7) - evenSum);
      float finalCoeff = 0.0f;

      if (p1.isReceiver()) {
         switch (p1.getBloodType()) {
            case ARHP, BRHP, ABRHN:
               finalCoeff = 0.18f;
               break;
            case ABRHP:
               finalCoeff = 0.27f;
               break;
            case ARHN, BRHN, ZRHP:
               finalCoeff = 0.12f;
               break;
            case ZRHN:
               finalCoeff = 0.08f;
               break;
         }
         final_key = p1.isUrgency() ? sum*finalCoeff : sum*(finalCoeff - 0.05f);
      } else {
         switch (p1.getBloodType()) {
            case ARHP, BRHP, ABRHN:
               finalCoeff = -0.03f;
               break;
            case ABRHP:
               finalCoeff = -0.01f;
               break;
            case ARHN, BRHN:
               finalCoeff = -0.09f;
               break;
            case ZRHP:
               finalCoeff = -0.05f;
               break;
            case ZRHN:
               finalCoeff = -0.27f;
         }
         final_key = sum*finalCoeff;
      }
      return final_key;
   }
}
