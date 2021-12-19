/*    */ public class StopWatch
/*    */ {
/*  3 */   private long startTime = 0L;
/*  4 */   private long stopTime = 0L;
/*    */   
/*    */   private boolean running = false;
/*    */   
/*    */   public void start() {
/*  9 */     this.startTime = System.currentTimeMillis();
/* 10 */     this.running = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void stop() {
/* 15 */     this.stopTime = System.currentTimeMillis();
/* 16 */     this.running = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public long getElapsedTime() {
/*    */     long elapsed;
/* 23 */     if (this.running) {
/* 24 */       elapsed = System.currentTimeMillis() - this.startTime;
/*    */     } else {
/*    */       
/* 27 */       elapsed = this.stopTime - this.startTime;
/*    */     } 
/* 29 */     return elapsed;
/*    */   }
/*    */ }


/* Location:              C:\Users\Unixt\OneDrive\Desktop\Projects\Projects\java\reaction-test\Reaction test\!\StopWatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */