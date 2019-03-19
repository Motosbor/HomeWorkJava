package Lambda;

public class Main {

    public static void main(String[] args){


        Runnable run = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1);
                    System.out.println("Run 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable run1 = ()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println("Run 2");
            }
        };

        Thread thread = new Thread(andThen(run,run1));
        thread.start();

        Thread thread1 = new Thread(andThen(variableRun("Первый",10),variableRun("Второй",20)));
        thread1.start();

    }


    public static Runnable andThen(Runnable run1,Runnable run2){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                run1.run();

                run2.run();
            }

        };

        return runnable;

    }


    public static Runnable variableRun(String str,int i){
        Runnable run = () -> {
            for (int j = 0; j < i ; j++) {
                System.out.println(str);
            }
        };
        return run;
    }


}
