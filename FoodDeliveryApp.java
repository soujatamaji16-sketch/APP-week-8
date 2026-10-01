class FoodDeliveryTask extends Thread {
    private String activity;

    public FoodDeliveryTask(String name, String activity) {
        super(name);
        this.activity = activity;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread Name: " + getName() 
                    + " | Priority: " + getPriority() 
                    + " | Activity: " + activity + " (Stage " + i + ")");
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        FoodDeliveryTask orderProcessing = new FoodDeliveryTask("OrderProcessing", "Processing customer order and payment");
        FoodDeliveryTask deliveryTracking = new FoodDeliveryTask("DeliveryTracking", "Tracking delivery agent GPS location");
        FoodDeliveryTask notification = new FoodDeliveryTask("Notification", "Sending SMS and in-app status updates");

        orderProcessing.setPriority(Thread.MAX_PRIORITY);   
        deliveryTracking.setPriority(7);                    
        notification.setPriority(Thread.MIN_PRIORITY);       

        System.out.println("=== Food Delivery Multi-Tasking Service ===");
        orderProcessing.start();
        deliveryTracking.start();
        notification.start();
    }
}