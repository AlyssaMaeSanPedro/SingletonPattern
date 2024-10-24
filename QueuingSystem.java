public class QueuingSystem {

    private static QueuingSystem instance;
    private int currentQueueNumber;
    private int lastServedNumber;

    // Private constructor to prevent instantiation from outside
    private QueuingSystem() {
        this.currentQueueNumber = 0;
        this.lastServedNumber = 0;
    }

    // Public method to provide a global access point for the single instance
    public static synchronized QueuingSystem getInstance() {
        if (instance == null) {
            instance = new QueuingSystem();
        }
        return instance;
    }

    // Method to get the next queue number
    public synchronized int getNextQueueNumber() {
        currentQueueNumber++;
        return currentQueueNumber;
    }

    // Method to serve the next customer and update the last served number
    public synchronized void serveNext(String helpDeskId) {
        if (lastServedNumber < currentQueueNumber) {
            lastServedNumber++;
            System.out.println("Help Desk " + helpDeskId + " serving Queue Number: " + lastServedNumber);
        } else {
            System.out.println("Help Desk " + helpDeskId + ": No more customers in the queue.");
        }
    }

    // Method to reset the queue number based on a provided input
    public synchronized void resetQueueNumber(int newQueueNumber, String helpDeskId) {
        if (newQueueNumber >= lastServedNumber) {
            currentQueueNumber = newQueueNumber;
            System.out.println("Help Desk " + helpDeskId + " reset queue number to: " + currentQueueNumber);
        } else {
            System.out.println("Help Desk " + helpDeskId + ": Invalid reset number. It cannot be less than the last served number.");
        }
    }

    // Method to display the current status of the queue
    public synchronized void displayQueueStatus() {
        System.out.println("Current Queue Number: " + currentQueueNumber);
        System.out.println("Last Served Number: " + lastServedNumber);
    }
}
