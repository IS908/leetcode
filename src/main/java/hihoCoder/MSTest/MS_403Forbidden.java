package hihoCoder.MSTest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kevin on 2016/4/6.
 */
public class MS_403Forbidden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer[]> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            String tmp = scan.nextLine().replace('/', '.');
            Integer[] a = new Integer[6];
            a[4] = 32; // 子网掩码
            if (tmp.contains("allow")) {    // 允许
                a[5] = 1;
                String[] allow = tmp.substring(6).split("\\.");
                for (int m = 0; m < allow.length; m++) a[m] = Integer.valueOf(allow[m]);
            } else { // 禁止
                a[5] = 0;
                String[] deny = tmp.substring(5).split("\\.");
                for (int m = 0; m < deny.length; m++) a[m] = Integer.valueOf(deny[m]);
            }
            list.add(a);
        }

        ArrayList<String> res = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            String ip = scan.nextLine();
            if (isAllowed(list, ip)) res.add("YES");
            else res.add("NO");
        }
        for (String tmp : res) System.out.println(tmp);
    }

    private static boolean isAllowed(ArrayList<Integer[]> rules, String ip) {
        String[] ips = ip.split("\\.");
        int[] numIp = new int[4];
        for (int i = 0; i < 4; i++) numIp[i] = Integer.valueOf(ips[i]);
        for (Integer[] rule : rules) {
            if (matchIP(rule, numIp)) { // 匹配到该规则
                if (rule[5] == 1) return true;
                else return false;
            }
        }
        return true;
    }

    /**
     * 判断是否匹配该规则
     * @param rule 规则
     * @param ip   待匹配IP
     * @return 是否匹配该规则
     */
    private static boolean matchIP(Integer[] rule, int[] ip) {
        int mask = rule[4];
        if (mask == 0) return true;
        int seg = mask / 8;
        for (int i = 0; i < seg; i++) {
            if (rule[i] != ip[i]) return false;
        }
        long count = 0;
        for (int i = seg; i < 4; i++) count += count * 256 + rule[i] ^ ip[i];
        if (count == 0 || count < (long) (1 << (32 - mask))) return true;
        return false;
    }
}
