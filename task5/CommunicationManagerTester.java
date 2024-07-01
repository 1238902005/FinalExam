package finalexam.task5;

public class CommunicationManagerTester {
    public static void main(String[] args) {

        CommunicationManager manager = new CommunicationManager("http://example.com/endpoint");


        String response = manager.sendUserMessage("Hello, world!");
        System.out.println(response);
    }
}

