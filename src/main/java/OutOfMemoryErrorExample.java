import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        // Display initial memory information
        System.out.println("Initial Memory Stats:");
        System.out.println("Total Heap Memory: " + runtime.totalMemory() / (1024 * 1024) + " MB");
        System.out.println("Free Heap Memory: " + runtime.freeMemory() / (1024 * 1024) + " MB");
        System.out.println("Max Heap Memory: " + runtime.maxMemory() / (1024 * 1024) + " MB");

        List<Object> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new Object());
                // Optional: Uncomment this if you want periodic memory updates
                // System.out.println("Free Memory: " + runtime.freeMemory() / (1024 * 1024) + " MB");
            }
        } catch (OutOfMemoryError e) {
            // Display memory information when OutOfMemoryError occurs
            System.out.println("\nMemory Stats After OutOfMemoryError:");
            System.out.println("Total Heap Memory: " + runtime.totalMemory() / (1024 * 1024) + " MB");
            System.out.println("Free Heap Memory: " + runtime.freeMemory() / (1024 * 1024) + " MB");
            System.out.println("Max Heap Memory: " + runtime.maxMemory() / (1024 * 1024) + " MB");
            System.out.println("Caught OutOfMemoryError: " + e.getMessage());
        }
    }
}
