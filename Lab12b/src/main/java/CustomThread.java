public class CustomThread extends Thread {
    public long timeProcess = 10000;

    public CustomThread(long timeProcess) {
        this.timeProcess = timeProcess;

    }

    @Override
    public void run() {
        System.out.println("Process Started!");
        try {
            Thread.sleep(timeProcess);
            System.out.println("Process done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
