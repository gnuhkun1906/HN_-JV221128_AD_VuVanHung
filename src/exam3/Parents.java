package exam3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Parents {
    public static Queue<String> parents = new LinkedList<>();
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát\n");
            System.out.println("Nhập vào lựa cho của bạn");
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    createParentName();
                    break;
                case 2:
                    nextParent();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Số bạn nhập không trùng khớp, vui lòng nhập lại");
                    choice=Integer.parseInt(scanner.nextLine());
            }
        }
    }
    public static void createParentName(){
        System.out.println("Nhập vào tên phụ huynh");
        String inputName=scanner.nextLine();
        parents.add(inputName);
    }
    public static void nextParent(){
        System.out.println("Phụ huynh tiếp theo là :"+parents.poll());

    }
}
