package WrapperClasss;

public class Methods {

    public static void waitJVM(int time){
       try{
           Thread.sleep(time);
       }catch(InterruptedException e){
           throw new RuntimeException(e);
        }
    }
}
