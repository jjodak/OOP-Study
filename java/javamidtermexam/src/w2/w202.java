//(실습과제 2-2 입력받기) 키보드로부터 입력받기
//1. 회원가입을 위해 위 항목을 입력받는 프로그램을 작성하세요.
//
//이름(문자열)
//나이(정수형)
//생년월일 8자리(정수형)
//키(실수형)
//입력을 모두 받으면 입력받은 내용을 화면에 출력

package w2;

import java.util.*;

public class w202 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("이름을 입력하세요");
    String name = sc.next();

    System.out.println("나이를 입력하세요");
    int age = sc.nextInt();

    System.out.println("생년월일을 입력하세요");
    int birth = sc.nextInt();

    System.out.println("키를 입력하세요");
    float hight = sc.nextFloat();

    System.out.println(name);
    System.out.println(age);
    System.out.println(birth);
    System.out.println(hight);
    }
}
