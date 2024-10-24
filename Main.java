public class Main {
    public static void main(String[] args) {
        // Create instances for three help desk stations
        HelpDesk desk1 = new HelpDesk("Desk 1");
        HelpDesk desk2 = new HelpDesk("Desk 2");
        HelpDesk desk3 = new HelpDesk("Desk 3");

        QueuingSystem queueSystem = QueuingSystem.getInstance();

        // Simulate adding customers to the queue
        System.out.println("New Queue Number: " + queueSystem.getNextQueueNumber());
        System.out.println("New Queue Number: " + queueSystem.getNextQueueNumber());

        // Each desk serves customers
        desk1.serveCustomer();
        desk2.serveCustomer();

        // Reset queue from Desk 3 for a specific situation
        desk3.resetQueue(10);

        // Display the current status of the queue
        queueSystem.displayQueueStatus();

        // Desk 3 continues to serve
        desk3.serveCustomer();
    }
}
