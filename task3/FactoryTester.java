package finalexam.task3;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        Person person1 = new Person("John", "Doe", "123456789");
        Person person2 = new Person("Jane", "Smith", "987654321");

      
        factory.addPerson(person1);
        factory.addPerson(person2);


        System.out.println("Current staff: " + factory.getStaff());


        factory.saveStaffToFile("staff.dat");


        factory = new PaperFactory();


        factory.loadStaffFromFile("staff.dat");


        System.out.println("Loaded staff: " + factory.getStaff());

        factory.deletePerson(person1);


        System.out.println("Updated staff: " + factory.getStaff());
    }
}
