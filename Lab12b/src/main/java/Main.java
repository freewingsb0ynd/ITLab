import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws TimeOutException {
        System.out.println("Solution 1: ");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Task());

        try {
            System.out.println("Started..");
            System.out.println(future.get(3, TimeUnit.SECONDS));
            System.out.println("Finished!");
        } catch (TimeoutException e) {
            future.cancel(true);
            System.out.println("Terminated!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();

        System.out.println("Solution 2: ");
        CustomThread t = new CustomThread(5000);
        try {
            TimeoutController.execute(t, 3000);
        }catch (TimeOutException e){

        }



    }
}
