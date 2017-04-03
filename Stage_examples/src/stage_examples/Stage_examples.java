package stage_examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Stage_examples {


    public static void main(String[] args) {
        stage3();
    }
    
    public static void stage2() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> read = new ArrayList<>();
        String str = in.nextLine();
        System.out.println("-----"+str+"-----\n");
        String[] split_str = str.split(" ");
        
        Comparator<String> cmpe = new ExampleComparator();
        
        System.out.println("-----END-----\n");
        for (int i = 0; i < split_str.length; i++) {
            read.add(split_str[i]);
        }
        Collections.sort(read, cmpe);
        for (int i = 0; i < split_str.length; i++) {
            System.out.println(read.get(i));
        }
    }
    
    public static void stage3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please right your string:");
        String str = in.nextLine();
        System.out.println("Please right characters that you want to count:");
        String chars = in.nextLine();
        int ans = 0;
        for (int i = 0; i < chars.length(); i++) {
            ans += countChars(str, chars.charAt(i));
        }
        System.out.println(ans);
    }
    
    public static int countChars(String str, char ch) {
        int ans = 0, start_index = 0;
        while ((start_index = str.indexOf(ch, start_index)) != -1) {
            start_index++;
            ans++;
        }
        return ans;
    }
}


class ExampleComparator  implements Comparator<String> {
  @Override
  public int compare(String obj1, String obj2) {
    if (obj1.equals(obj2)) {
        return 0;
    }
    if (obj1 == null) {
        return -1;
    }
    if (obj2 == null) {
        return 1;
    }
    if (obj1.length() >= obj2.length()) {
        return 1;
    } else {
        return -1;
    }
  }
}
