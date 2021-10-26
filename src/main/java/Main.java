import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static volatile Boolean isSwitchedOn;

    public static void main(String[] args) {
        System.out.println("Задача 1. Самая бесполезная коробка");

        Thread switcherOn = new Switcher(true);
        Thread switcherOff = new Switcher(false);

        final ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(switcherOn);
        threadPool.execute(switcherOff);

        final int timeOutLong = 15_000;
        sleep(timeOutLong);

        switcherOn.interrupt();
        switcherOff.interrupt();
        threadPool.shutdown();
        final int timeOutShort = 100;
        sleep(timeOutShort);
        System.out.println("Конец");

        return;

    }

    private static void sleep(int timeOut) {

        try {
            Thread.sleep(timeOut);
//            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
//            return false;
        }

    }
}
