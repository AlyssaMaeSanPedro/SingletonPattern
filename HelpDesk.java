public class HelpDesk {
    public static void main(String[] args) {
        QueuingSystem queueSystem = QueuingSystem.getInstance();

        queueSystem.serveCustomer("Desk 1");

        queueSystem.serveCustomer("Desk 2");
        queueSystem.callNext("Desk 2");
        queueSystem.serveCustomer("Desk 2");

        queueSystem.callNext("Desk 3");
        queueSystem.serveCustomer("Desk 3");

        queueSystem.resetQueue(1);

        queueSystem.serveCustomer("Desk 1");
        
        queueSystem.callNext("Desk 3");
        queueSystem.serveCustomer("Desk 3");
    }
}