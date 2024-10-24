public class HelpDesk {
    private String id;

    public HelpDesk(String id) {
        this.id = id;
    }

    // Method for serving the next customer
    public void serveCustomer() {
        QueuingSystem queueSystem = QueuingSystem.getInstance();
        queueSystem.serveNext(this.id);
    }

    // Method for resetting the queue
    public void resetQueue(int newQueueNumber) {
        QueuingSystem queueSystem = QueuingSystem.getInstance();
        queueSystem.resetQueueNumber(newQueueNumber, this.id);
    }
}
