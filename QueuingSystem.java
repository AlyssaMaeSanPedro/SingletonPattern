public class QueuingSystem {
    private static QueuingSystem instance;
    private int queueNumber;
    private boolean isBeingServed;

    private QueuingSystem() {
        queueNumber = 0;
        isBeingServed = false;
    }

    public static synchronized QueuingSystem getInstance() {
        if (instance == null) {
            instance = new QueuingSystem();
        }
        return instance;
    }

    public synchronized void serveCustomer(String deskId) {
        if (!isBeingServed) {
            isBeingServed = true;
            queueNumber++;
            System.out.println(deskId + " is now serving customer number " + queueNumber);
        } else {
            System.out.println(deskId + " attempted to serve, but another desk is currently serving customer number " + queueNumber);
        }
    }

    public synchronized void callNext(String deskId) {
        if (isBeingServed) {
            isBeingServed = false;
            System.out.println(deskId + " called the next customer.");
        } else {
            System.out.println(deskId + " attempted to call the next customer, but no one is currently being served.");
        }
    }

    public void resetQueue(int number) {
        queueNumber = number - 1;
        System.out.println("Queue has been reset to start from customer number: " + number);
        isBeingServed = false;
    }
}