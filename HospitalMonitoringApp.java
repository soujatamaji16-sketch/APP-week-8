class HospitalTask extends Thread {
    public HospitalTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[Executing] Thread Name: " + getName() 
                    + " | Priority: " + getPriority() 
                    + " | Step: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
        }
    }
}

public class HospitalMonitoringApp {
    public static void main(String[] args) {
        HospitalTask emergencyAlert = new HospitalTask("EmergencyAlert");
        HospitalTask vitalMonitor = new HospitalTask("VitalMonitor");
        HospitalTask reportGenerator = new HospitalTask("ReportGenerator");

        emergencyAlert.setPriority(Thread.MAX_PRIORITY);  // Priority 10
        vitalMonitor.setPriority(Thread.NORM_PRIORITY);   // Priority 5
        reportGenerator.setPriority(Thread.MIN_PRIORITY); // Priority 1

        System.out.println("--- Starting Hospital Monitoring Threads ---");
        System.out.println("Thread: " + emergencyAlert.getName() + " | Assigned Priority: " + emergencyAlert.getPriority());
        System.out.println("Thread: " + vitalMonitor.getName() + " | Assigned Priority: " + vitalMonitor.getPriority());
        System.out.println("Thread: " + reportGenerator.getName() + " | Assigned Priority: " + reportGenerator.getPriority());
        System.out.println("--------------------------------------------");

        emergencyAlert.start();
        vitalMonitor.start();
        reportGenerator.start();
    }
}