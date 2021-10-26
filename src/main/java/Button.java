import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Button {
    public volatile boolean isSwitchedOn;

    // SingleTone ++

    private Button(){
        isSwitchedOn = false;
    };

    private static class Holder {
        public static final Button BUTTON = new Button();
    }

    public static Button get()  {
        return Holder.BUTTON;
    }

    // SingleTone --

}
