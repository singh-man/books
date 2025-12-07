package utils.timer;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author msingh
 */
public class StopWatch {

    private interface Msg {

        String getMsg();
    }

    private enum State implements Msg {

        CREATED {
                    @Override
                    public String getMsg() {
                        return "Invalid Operation! Can Start or Stop the Stopwatch";
                    }
                },
        RUNNING {
                    @Override
                    public String getMsg() {
                        return "Invalid Operation! Can Log or Stop the Stopwatch";
                    }
                },
        STOPPED {
                    @Override
                    public String getMsg() {
                        return "Invalid Operation! Create a new Stopwatch";
                    }
                }
    }

    private Map<String, Long> logBook;
    private long startTime, lastLoggedTime;
    private State state;

    public StopWatch() {
        logBook = new LinkedHashMap<String, Long>();
        state = State.CREATED;
    }

    public StopWatch start() {
        if (state == State.CREATED) {
            startTime = getTime();
            lastLoggedTime = startTime;
            state = State.RUNNING;
        } else {
            System.out.println("StopWatch.start() : " + state.getMsg());
        }
        return this;
    }

    public StopWatch stop() {
        if (state == State.CREATED || state == State.RUNNING) {
            long stopTime = getTime();
            logBook.put("Total time", stopTime - startTime);
            state = State.STOPPED;
        } else {
            System.out.println("StopWatch.stop() : " + state.getMsg());
        }
        return this;
    }

    public StopWatch log(String msg) {
        if (state == State.RUNNING) {
            long tmpTime = getTime();
            logBook.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date(System.currentTimeMillis())) + " : " + msg, tmpTime - lastLoggedTime);
            lastLoggedTime = tmpTime;
        } else {
            System.out.println("StopWatch.log() : " + state.getMsg());
        }
        return this;
    }

    /**
     * Simulate suspends! Resets last logged in-memory- time (new log will take
     * current time when reset was called) i.e. will not reset the StopWatch
     * Start Time and will not reset any time(s) that is/are already logged
     */
    public StopWatch reset() {
        if (state == State.RUNNING) {
            lastLoggedTime = getTime();
            return this;
        } else {
            throw new RuntimeException(state.getMsg());
        }
    }

    /**
     * This might take few ms extra
     */
    public StopWatch printOut(OutputStream os) {
        long time = getTime();
        logBook.put("Time Till now", time - startTime);
        try {
            os.write(this.toString().getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public StopWatch printConsole() {
        long time = getTime();
        logBook.put("Time Till now", time - startTime);
        printOut(System.err.printf(""));
        System.out.println("StopWatch.printConsole() : " + this);
        return this;
    }

    private long getTime() {
        return System.nanoTime();
    }

    @Override
    public String toString() {
        return logBook.toString();
    }

//   public static void dumpImage(ImageData imageData, String name) {
//      ImageLoader il = new ImageLoader();
//      il.data = new ImageData[] {imageData};
//      il.save(name + System.currentTimeMillis() + ".png", SWT.IMAGE_PNG);
//   }
    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(3000l);
        sw.log("thread sleep 3s");
        Thread.sleep(1000l);
        sw.log("thread sleep 1s");
        Thread.sleep(2500l);
        sw.log("thread sleep 2.5s");
        sw.start();
        Thread.sleep(3000l);
        sw.reset();
        Thread.sleep(5000l);
        sw.log("Thread 5s total wait is 8s");
        sw.stop();
        sw.start();
        System.out.println(sw);
        sw.printConsole();
        List<String> asList = Arrays.asList("a", "b", "e");
        asList.sort((e1, e2) -> {
            return -1;
        });
        asList.forEach(System.out::println);
    }

}
