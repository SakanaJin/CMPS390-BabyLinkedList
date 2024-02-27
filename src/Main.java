import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Integer[] array = {0,1,2,3,4,5,6,7,8,9};
        LinkedList<Integer> list = new LinkedList<Integer>(array);
        System.out.println("0: Quit\n1: append\n2: insert\n3: delete\n4: get\n5: show list");
        int in;
        int num, index;
        do{
            System.out.print(">>> ");
            in = input.nextInt();
            System.out.println();
            try{
                switch(in){
                    case 0: break;
                    case 1: System.out.print("append: ");
                            num = input.nextInt();
                            list.append(num);
                            System.out.println();
                            break;
                    case 2: System.out.print("index: ");
                            index = input.nextInt();
                            System.out.println();
                            System.out.print("insert: ");
                            num = input.nextInt();
                            list.insert(index, num);
                            System.out.println();
                            break;
                    case 3: System.out.print("index: ");
                            index = input.nextInt();
                            list.delete(index);
                            System.out.println();
                            break;
                    case 4: System.out.print("index: ");
                            index = input.nextInt();
                            System.out.println("\n" + list.get(index));
                            break;
                    case 5: list.showList();
                            break;
                    default: System.out.println("Incorrect number");
                            break;
                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Index out of bounds");
            }
        }
        while(in != 0);
        input.close();
    }
}