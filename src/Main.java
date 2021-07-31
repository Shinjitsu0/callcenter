public class Main {
    public static void main(String[] args) {
        Ats ats = new Ats();
        Operator operator1 = new Operator("Василий", ats);
        Operator operator2 = new Operator("Владимир", ats);
        Operator operator3 = new Operator("Маша", ats);

        ats.start();

        operator1.start();

        operator2.start();

        operator3.start();
    }
}
