public class EightQueens {
    static final int N = 8;
    static int[] queens = new int[N];

    static boolean isSafe(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (queens[i] == c || Math.abs(queens[i] - c) == Math.abs(i - r)) {
                return false;
            }
        }
        return true;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean solve(int r) {
        if (r == N) {
            return true;
        }
        for (int c = 0; c < N; c++) {
            if (isSafe(r, c)) {
                queens[r] = c;
                if (solve(r + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (solve(0)) {
            printBoard();
        } else {
            System.out.println("Решения не нашлось. Запустите еще раз.");
        }
    }
}
