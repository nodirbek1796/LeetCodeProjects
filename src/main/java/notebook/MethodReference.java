package notebook;

public class MethodReference {

    public static void printHello(String name){
        System.out.println("Hello Mr." + name + "!");
    }

    public void printNews(){
        System.out.println("Hello Dear!\n" +
                "How nice day today!");
    }

    public MethodReference() {
        System.out.println("It is constructor of MethodReference class!");
    }
}
