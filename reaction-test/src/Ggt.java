/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ggt
/*    */ {
/*    */   public static long Berechnung(long number1, long number2) {
/*  7 */     long rest, temp = 0L;
/*  8 */     long temp1 = 0L;
/*  9 */     long out = 0L;
/* 10 */     if (number1 > number2) {
/* 11 */       long mult = number1 / number2;
/* 12 */       rest = number1 - number2 * mult;
/* 13 */       temp = rest;
/* 14 */       if (rest == 0L)
/* 15 */         out = number2; 
/* 16 */       if (rest != 0L) {
/* 17 */         mult = number2 / temp;
/* 18 */         rest = number2 - temp * mult;
/* 19 */         temp1 = rest;
/* 20 */         if (rest == 0L) {
/* 21 */           out = temp;
/*    */         }
/*    */       } 
/*    */     } else {
/*    */       
/* 26 */       long mult = number2 / number1;
/* 27 */       rest = number2 - number1 * mult;
/* 28 */       temp = rest;
/* 29 */       if (rest == 0L)
/* 30 */         out = number1; 
/* 31 */       if (rest != 0L) {
/* 32 */         mult = number1 / temp;
/* 33 */         rest = number1 - temp * mult;
/* 34 */         temp1 = rest;
/* 35 */         if (rest == 0L) {
/* 36 */           out = temp;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 41 */     while (rest != 0L) {
/* 42 */       long l = temp / temp1;
/* 43 */       rest = temp - temp1 * l;
/* 44 */       temp = rest;
/* 45 */       if (rest == 0L) {
/* 46 */         out = temp1;
/*    */         break;
/*    */       } 
/* 49 */       l = temp1 / temp;
/* 50 */       rest = temp1 - temp * l;
/* 51 */       temp1 = rest;
/* 52 */       if (rest == 0L) {
/* 53 */         out = temp;
/*    */         break;
/*    */       } 
/*    */     } 
/* 57 */     return Math.abs(out);
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 61 */     System.out.print(Berechnung(84L, 106L));
/*    */   }
/*    */ }


/* Location:              C:\Users\Unixt\OneDrive\Desktop\Projects\Projects\java\reaction-test\Reaction test\!\Ggt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */