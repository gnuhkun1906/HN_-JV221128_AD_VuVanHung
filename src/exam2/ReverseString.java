package exam2;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public  static Scanner scanner=new Scanner(System.in);
  public static   Stack<String> stack=new Stack<String>();
    public static void main(String[] args) {
        while (true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            System.out.println("Nhập vào lựa chọn của bạn");
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    createString();
                    break;
                case 2:
                    reverse();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Số bạn nhập không trùng khớp, vui lòng nhâpj lại");
                    choice=Integer.parseInt(scanner.nextLine());
            }

        }
    }
    public  static void createString() {
        System.out.println("Nhập vào câu bất kì");
        String inputStr=scanner.nextLine();
        String arrStr[] = inputStr.split(" ");
        for (int i = 0; i < arrStr.length; i++) {
            stack.push(arrStr[i]);
        }

    }
    public static void reverse(){

        for (int i = 0; i <= stack.size()+1; i++) {
            System.out.println(stack.pop()+" ");
        }
    }
}
