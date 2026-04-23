package w7.w701;

import java.io.*;
import java.util.*;

public class phonebook {
    public static void main(String[] args) {
        Vector<person> book = new Vector<>();
        Scanner sc = new Scanner(System.in);

        BufferedReader br = null;
        BufferedWriter bw = null;
        File f = new File("./phonebook.txt");
        if (f.exists()) {
            try {
                br = new BufferedReader(new FileReader(f));

                while (true) {
                    String l = br.readLine();
                    if (l != null) {
                        String[] t = l.split(" ");
                        person p = new person(t[0], t[1], t[2]);
                        book.add(p);
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("저장된 데이터를 갖고 왔습니다.");
        while (true) {
            System.out.println("메뉴 : 입력(1), 삭제(2), 검색(3), 전체리스트(4), 저장(5), 종료(6)");
            int input = sc.nextInt();

            if (input == 1) {
                System.out.println("이름 전화번호 이메일을 입력하세요.");
                person p = new person();
                p.name = sc.next();
                p.phone = sc.next();
                p.email = sc.next();
                book.add(p);
                System.out.println("전화번호부에 입력했습니다.");
            } else if (input == 2) {
                System.out.println("삭제할 사람의 이름을 입력하세요");
                String n = sc.next();
                for (int i = 0; i < book.size(); i++) {
                    person p = book.get(i);
                    if (n.equals(p.name)) {
                        book.remove(i);
                    }
                }
            } else if (input == 3) {
                System.out.println("검색할 사람의 이름을 입력하세요");
                String n = sc.next();
                for (int i = 0; i < book.size(); i++) {
                    person p = book.get(i);
                    if (n.equals(p.name)) {
                        System.out.println(p.name + " " + p.phone + " " + p.email);
                    }
                }
            } else if (input == 4) {
                for (int i = 0; i < book.size(); i++) {
                    person p = book.get(i);
                    System.out.println(p.name + " " + p.phone + " " + p.email + "\r\n");
                }
            } else if (input == 5) {
                try {
                    bw = new BufferedWriter(new FileWriter(f));
                    for (int i = 0; i < book.size(); i++) {
                        person p = book.get(i);
                        bw.write(p.name + " " + p.phone + " " + p.email + "\r\n");
                    }
                    bw.close();
                    System.out.println("전화번호부가 저장되었습니다.");
                } catch (IOException e) {
                    System.out.println("파일 저장 중 오류가 발생했습니다.");
                }
            } else if (input == 6) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

    }
}
