public class SingletonBreakUsingClone {
    public static void main(String[] args) throws CloneNotSupportedException{
        SingletonBreakClone singletonBreakClone = SingletonBreakClone.getInstance();
        SingletonBreakClone singletonBreakClone2 = (SingletonBreakClone)singletonBreakClone.clone();

        System.out.println(singletonBreakClone.hashCode());
        System.out.println(singletonBreakClone2.hashCode());
    }
    
}

class DemoClone implements Cloneable{
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class SingletonBreakClone extends DemoClone{
    private static SingletonBreakClone instance = null;
    private SingletonBreakClone(){

    }

    public static SingletonBreakClone getInstance(){
        if(instance == null){
            instance = new SingletonBreakClone();
        }
        return instance;
    }
    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Cloning not allowed");
    }
}
