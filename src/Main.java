public class Main {
   public static void main(String[] args) throws InterruptedException {
      Ats ats = new Ats();
      Operator operator1 = new Operator("Василий", ats.getCall());
      Operator operator2 = new Operator("Владимир", ats.getCall());
      Operator operator3 = new Operator("Маша", ats.getCall());

      ats.start();

      operator1.start();

      operator2.start();

      operator3.start();
   }
}
