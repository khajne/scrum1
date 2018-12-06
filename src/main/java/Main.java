public class Main {

    public static void main(String[] args) {
        Developer developer = new Developer("1", "2");

        System.out.println("Deklaracja danych -----------------");
        EmplyeeRepository employeeRepository1 = EmplyeeRepository.INSTANCE;
        Developer stefan = new Developer ("Stefan", "Pytlas");
        System.out.println(employeeRepository1.create(stefan));
        Tester janek = new Tester ("Janek", "Dolas");
        System.out.println(employeeRepository1.create(janek));
        System.out.println("Stefan id: " + stefan.getId());
        System.out.println("Janek id: " + janek.getId());

        System.out.println("");
        System.out.println("testy -----------------");
        System.out.println("test Lambdy (old id 1): ");
        System.out.println(employeeRepository1.getById(0).toString());
        System.out.println("test update: ");
        Developer nowyStefan = new Developer("nowy","stefan");
        nowyStefan.setId(0);
        System.out.println(employeeRepository1.update(nowyStefan).toString());
        System.out.println("test update (new id 1): ");
        //System.out.println(employeeRepository1.getById(2).toString());







        //System.out.println(employeeRepository1.toString());

    }
}
