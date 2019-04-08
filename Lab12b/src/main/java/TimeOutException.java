public class TimeOutException extends Exception {
    /**
     * Signals that the task timed out.
     */

    /** Create an instance */
    public TimeOutException() {

        System.out.println("Process is timed out");

    }
}