import java.lang.reflect.Constructor;

public class SingletonBreak {
    public static void main(String[] args) throws Exception{
        SingletonReflection singletonReflection1 = SingletonReflection.getInstance();
        SingletonReflection singletonReflection2 = null;

        Constructor [] constructors = SingletonReflection.class.getDeclaredConstructors();

        for(Constructor constructor : constructors){
            constructor.setAccessible(true);
            singletonReflection2 = (SingletonReflection)constructor.newInstance();
        }
        System.out.println(singletonReflection1.hashCode());
        System.out.println(singletonReflection2.hashCode());
    }
    
}

class SingletonReflection{
    private static SingletonReflection instance = null;

    private SingletonReflection(){
        if(instance != null){
            throw new RuntimeException("Cant break singleton pattern");
        }
    }

    public static SingletonReflection getInstance(){
        if(instance == null){
            instance = new SingletonReflection();
        }
        return instance;
    }
}
