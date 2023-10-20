import java.time.format.SignStyle;
import java.util.concurrent.SynchronousQueue;
import java.util.function.DoubleBinaryOperator;

public class SingletonPattern {
    public static void main(String[] args) {

        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();

        System.out.println(eagerSingleton1.hashCode());
        System.out.println(eagerSingleton2.hashCode());
        
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        System.out.println(lazySingleton1.hashCode());
        System.out.println(lazySingleton2.hashCode());

        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getInstance();

        System.out.println(threadSafeSingleton1.hashCode());
        System.out.println(threadSafeSingleton2.hashCode());

        DoubleLockingSingleton doubleLockingSingleton1 = DoubleLockingSingleton.getInstance();
        DoubleLockingSingleton doubleLockingSingleton2 = DoubleLockingSingleton.getInstance();

        System.out.println(doubleLockingSingleton1.hashCode());
        System.out.println(doubleLockingSingleton2.hashCode());
        
    }
    
}

class EagerSingleton{
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}

class LazySingleton{
    private static LazySingleton instance = null;
    
    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
            return instance;
        }
        return instance;
    }
}

class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance = null;

     private ThreadSafeSingleton(){

     }

     public static ThreadSafeSingleton getInstance(){
        synchronized(ThreadSafeSingleton.class){
            if(instance==null){
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }
     }
}

class DoubleLockingSingleton{
    private static DoubleLockingSingleton instance = null;

    private DoubleLockingSingleton(){

    }

    public static DoubleLockingSingleton getInstance(){
        if(instance == null){
            synchronized(DoubleLockingSingleton.class){
                if(instance == null){
                    instance = new DoubleLockingSingleton();
                }
            }
        }
        return instance;
    }
}
