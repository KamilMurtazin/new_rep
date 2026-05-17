package AISD_homeworks.semestrovka2;

public class RabinKarp {
    public static long steps = 0;

    public static int find(String s, String p) {
        steps = 0;
        int n = s.length();
        int m = p.length();
        if (m > n) return -1;
        long d = 31;
        long q = 1000000007;
        long h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
            steps++;
        }
        long ph = 0;
        for (int i = 0; i < m; i++) {
            ph = (ph * d + (p.charAt(i) - 'a' + 1)) % q;
            steps++;
        }
        long th = 0;
        for (int i = 0; i < m; i++) {
            th = (th * d + (s.charAt(i) - 'a' + 1)) % q;
            steps++;
        }
        for (int i = 0; i <= n - m; i++) {
            steps++;
            if (th == ph) {
                int j;
                for (j = 0; j < m; j++) {
                    steps++;
                    if (s.charAt(i + j) != p.charAt(j)) break;
                }
                if (j == m) return i;
            }
            if (i < n - m) {
                char a = s.charAt(i);
                char b = s.charAt(i + m);
                long av = a - 'a' + 1;
                long bv = b - 'a' + 1;
                th = (th - av * h % q + q) % q;
                th = (th * d + bv) % q;
                steps++;
            }
        }
        return -1;
    }
}