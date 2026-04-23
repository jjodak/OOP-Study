package w7.w702;

import java.util.*;
import java.io.*;

public class game {
    public static void main(String[] args) {

        HashMap<String, hero> playersave = new HashMap<>();
        HashMap<String, zombie> zombiesave = new HashMap<>();
        BufferedReader br = null;
        BufferedWriter bw = null;
        int round = 1;

        File f = new File("./zombie.sav");
        if (f.exists()) {
            try {
                br = new BufferedReader(new FileReader(f));
                while (true) {
                    String l = br.readLine();
                    if (l != null) {
                        String[] t = l.split(" ");
                        if (t[0].equals("플레이어")) {
                            hero h = new hero(t[1], Integer.parseInt(t[2]), Integer.parseInt(t[3]));
                            playersave.put(t[0], h);
                        } else if (t[0].equals("라운드")) {
                            round = Integer.parseInt(t[1]);
                        } else {
                            zombie z = new zombie(t[1], Integer.parseInt(t[2]), Integer.parseInt(t[3]));
                            zombiesave.put(t[0], z);
                        }
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("세이브파일을 갖고 왔습니다.");
        } else {
            playersave.put("플레이어", new hero("준혁", 1, 3));
            zombiesave.put("1번좀비", new zombie("1번", 10, 1));
            zombiesave.put("2번좀비", new zombie("2번", 20, 1));
            zombiesave.put("3번좀비", new zombie("3번", 30, 1));
            zombiesave.put("4번좀비", new zombie("4번", 40, 1));
            zombiesave.put("5번좀비", new zombie("5번", 50, 1));
        }

        while (true) {
            hero h = playersave.get("플레이어");
            h.move();

            for (zombie z : zombiesave.values()) {
                z.move();
            }
            System.out.println("=======" + round + "라운드=======");
            System.out.println("플레이어 위치 : " + h.pos);
            System.out.println("========================");
            for (zombie z : zombiesave.values()) {
                System.out.println(z.name + " 위치 : " + z.pos);
            }

            if (h.pos == 50) {
                System.out.println("목적지 도착!!");
                f.delete();
                break;
            }
            for (zombie z : zombiesave.values()) {
                if (h.pos == z.pos) {
                    h.pos = 1;
                    h.hp--;
                    System.out.println("좀비에게 잡혔습니다. 처음으로 돌아갑니다. 목숨이 깎입니다. 남은 목숨" + h.hp);
                }
            }
            if (h.hp == 0) {
                System.out.println("목숨이 다 닳았습니다. 게임 오버");
                f.delete();
                break;
            }
            round++;

            try {
                bw = new BufferedWriter(new FileWriter(f));

                hero player = playersave.get("플레이어");
                bw.write("플레이어" + " " + player.name + " " + player.pos + " " + player.hp + "\n");

                for (String key : zombiesave.keySet()) {
                    zombie z = zombiesave.get(key);
                    bw.write(key + " " + z.name + " " + z.pos + " " + z.hp + "\n");
                }
                bw.write("라운드" + " " + round + "\n");
                bw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
