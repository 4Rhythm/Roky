package boj.january;

import java.io.*;
import java.util.*;

class Virus {
    int x,y;
    boolean activate;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
        activate = false;
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Problem_17142 {
    static int N, M;
    static int[][] board, checkBoard;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] visited;
    static List<int[]> combinationList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스 수

        board = new int[N][N];
        checkBoard = new int[N][N]; // 거리 확인 배열
        combinationList = new ArrayList<>();

        int virusCount = 0;
        int spaceCount = 0;

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {

                int input = Integer.parseInt(st.nextToken());

                if (input == 2) {
                    virusCount ++;
                } else if (input == 0){
                    spaceCount ++;
                }
                board[i][j] = input;
            }
        }

        // 바이러스를 퍼트릴 공간이 없으면 종료
        if (spaceCount == 0) {
            System.out.println(0);
            return;
        }

        // 바이러스 정보 저장
        Virus[] virusArrays = new Virus[virusCount];
        visited = new boolean[virusCount];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 2) {
                    virusArrays[index++] = new Virus(i, j);
                }
            }
        }

        // 조합 생성
        combination(0, 0, new int[M], 0);

        // bfs 탐색
        int minResult = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();

        int aaaa = 0;
        for (int[] combination : combinationList) {
            int[][] newBoard = new int[N][N]; // 복사된 배열
            int tmp = 0;
            aaaa++;
            for (int[] arr : board) {
                newBoard[tmp++] = Arrays.copyOf(arr, N);
            }
            // check board 초기화
            for (int i = 0; i < N; i++) {
                Arrays.fill(checkBoard[i], 0);
            }

            // 생성된 조합 탐색
            for (int i : combination) {
                int x = virusArrays[i].x;
                int y = virusArrays[i].y;
                checkBoard[x][y] = 1;
                newBoard[x][y] = 1;
                q.add(new Node(x, y));
            }

            // bfs 탐색
            while (!q.isEmpty()) {
                Node n = q.poll();
                // 상 하 좌 우
                for (int i = 0; i < 4; i++) {
                    int nextX = n.x + dx[i];
                    int nextY = n.y + dy[i];

                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) { // 범위 체크
                        if (newBoard[nextX][nextY] == 0) {
                            q.add(new Node(nextX, nextY));
                            checkBoard[nextX][nextY] = checkBoard[n.x][n.y] + 1;
                            newBoard[nextX][nextY] = -1;
                        } else if (newBoard[nextX][nextY] == 2) {
                            q.add(new Node(nextX, nextY));
                            checkBoard[nextX][nextY] = checkBoard[n.x][n.y] + 1;
                            newBoard[nextX][nextY] = -1;
                        }
                    }
                }
            }

            int maxDistance = -1;
            boolean check = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (newBoard[i][j] == 0) {
                        check = false;
                    }
                    if (checkBoard[i][j] > maxDistance && board[i][j] != 2) {
                        maxDistance = checkBoard[i][j];
                    }
                }
            }
            if (check) {
                minResult = Math.min(maxDistance - 1, minResult);
            }

        }
        if (minResult != Integer.MAX_VALUE) {
            System.out.println(minResult);
        } else {
            System.out.println(-1);
        }



    }

    // 조합 생성
    public static void combination(int index, int depth, int[] tmp, int start) {
        if (depth == M) {
            // 조합 저장 배열을 리스트에 저장
            int[] arr = Arrays.copyOf(tmp, M);
            combinationList.add(arr);
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[index] = i;
                combination(index + 1, depth + 1, tmp, i + 1);
                visited[i] = false;
            }
        }

    }


}
