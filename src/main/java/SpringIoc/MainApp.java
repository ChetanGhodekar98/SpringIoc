package SpringIoc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner=new Scanner(System.in);
        System.out.println("1. LAPTOP");
        System.out.println("2. PROJECTOR");
        int choice= scanner.nextInt();

        Machine machine=null;
        if(choice==1){
            machine=context.getBean("laptop", Laptop.class);
        } else if (choice==2) {
            machine=context.getBean("projector", Projector.class);
        }else {
            System.out.println("INVALID OPTION");
        }

        if(machine!=null){
            machine.getMachineInfo();
            machine.getMachinePrice();
        }else {
            System.out.println("SOMETHING WENT WRONG");
        }


    }
}
