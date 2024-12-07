import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTesting {

    private static ThreadLocal<String> localVariable = ThreadLocal.withInitial(() -> "Default Value");
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Testing");
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "postgres";
        String password = "root";
        //Class.forName("org.postgresql.Driver");
        Connection con =DriverManager.getConnection(url,user,password);
        System.out.println(con.getClass().getName());
       if(con != null){

           Thread thread1 = new Thread(() -> {
               localVariable.set("Thread 1 Local Variable");
               System.out.println("Thread 1 - ID: " + Thread.currentThread().getId());
               System.out.println("Thread 1 - Name: " + Thread.currentThread().getName());
               System.out.println("Thread 1 - Local Variable: " + localVariable.get());
           });

           Thread thread2 = new Thread(() -> {
               localVariable.set("Thread 2 Local Variable");
               System.out.println("Thread 2 - ID: " + Thread.currentThread().getId());
               System.out.println("Thread 2 - Name: " + Thread.currentThread().getName());
               System.out.println("Thread 2 - Local Variable: " + localVariable.get());
           });


           System.out.println("Connected to the database");
           System.out.println(Thread.currentThread().getThreadGroup().getName());
           System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
           System.out.println("Thread ID: " + Thread.currentThread().getId());
           System.out.println("Thread Name: " + Thread.currentThread().getName());
           System.out.println("Thread 1 - Local Variable: " + localVariable.get());


           thread1.start();
           thread2.start();
           con.close();
       }
    }
}
