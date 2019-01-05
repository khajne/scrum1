public class Main {

    public static void main(String[] args) {
        EmplyeeRepository employeeRepository = EmplyeeRepository.INSTANCE;

        for(int i=0;i<5;i++){
            Developer dev = new Developer("Fname" + i,"Lname"+i);
            employeeRepository.create(dev);
        }

        Tester tester = new Tester("Andrzej", "xx5");

        Manager manager = new Manager("man", "man");

        employeeRepository.create(tester);
        employeeRepository.create(manager);

        for (Employee employee : employeeRepository.getAll()) {
            System.out.println(employee.toString());
        }


    }
}
