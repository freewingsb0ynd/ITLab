import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(4000); // Just to demo a long running task of 4 seconds.
        return "Ready!";
    }

}