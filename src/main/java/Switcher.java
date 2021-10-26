public class Switcher extends Thread implements Runnable{

    final private boolean needSwitchedOn;

    public Switcher(boolean needSwitchedOn) {
        this.needSwitchedOn = needSwitchedOn;
    }

    @Override
    public void run() {
        final int timeOut = 500;

        Button button = Button.get();

//        sleep(timeOut);
        while (!isInterrupted()) {

            while(button.isSwitchedOn == needSwitchedOn){
                if (isInterrupted())
                    return;
            };

            if (!sleep(timeOut))
                return;
            button.isSwitchedOn = needSwitchedOn;
            System.out.printf("Тумблер %s.\n", (button.isSwitchedOn ? "включен": "выключен"));

        }
    }

    private boolean sleep(int timeOut) {

        try {
            super.sleep(timeOut);
            return true;
        } catch (InterruptedException e) {
            //e.printStackTrace();
            return false;
        }

    }

}
