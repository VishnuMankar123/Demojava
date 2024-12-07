import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class ErrorExample {


    public static void main(String[] args) {
        List<String> vmArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();

        // Check if HeapDumpOnOutOfMemoryError is enabled
        boolean heapDumpEnabled = vmArgs.contains("-XX:+HeapDumpOnOutOfMemoryError");
        System.out.println("HeapDumpOnOutOfMemoryError enabled: " + heapDumpEnabled);

        // Find the heap dump path if specified
        String heapDumpPath = null;
        for (String arg : vmArgs) {
            if (arg.startsWith("-XX:HeapDumpPath=")) {
                heapDumpPath = arg.substring("-XX:HeapDumpPath=".length());
                break;
            }
        }

        // Display the heap dump path or indicate it is not set
        if (heapDumpPath != null) {
            System.out.println("HeapDumpPath: " + heapDumpPath);
        } else {
            System.out.println("HeapDumpPath is not specified; default location will be used.");
        }
    }
}

