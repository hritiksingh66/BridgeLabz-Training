// Chef thread class
class Chef extends Thread {
    private String chefName;
    private String dish;
    private int preparationTime; // in milliseconds

    public Chef(String chefName, String dish, int preparationTime) {
        super(chefName);
        this.chefName = chefName;
        this.dish = dish;
        this.preparationTime = preparationTime;
    }

    @Override
    public void run() {
        System.out.println(chefName + " started preparing " + dish);
        
        // Calculate time for each progress step (25% intervals)
        int stepTime = preparationTime / 4;
        
        try {
            // 25% complete
            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dish + ": 25% complete");
            
            // 50% complete
            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dish + ": 50% complete");
            
            // 75% complete
            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dish + ": 75% complete");
            
            // 100% complete
            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dish + ": 100% complete");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RestaurantKitchen {
    public static void main(String[] args) {
        // Create 4 chef threads with different dishes and preparation times
        Chef chef1 = new Chef("Chef-1", "Pizza", 3000);      // 3 seconds
        Chef chef2 = new Chef("Chef-2", "Pasta", 2000);      // 2 seconds
        Chef chef3 = new Chef("Chef-3", "Salad", 1000);      // 1 second
        Chef chef4 = new Chef("Chef-4", "Burger", 2500);     // 2.5 seconds

        // Start all chefs
        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        try {
            // Manager waits for all chefs to complete
            chef1.join();
            chef2.join();
            chef3.join();
            chef4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nKitchen closed - All orders completed");
    }
}
