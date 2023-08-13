import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q28457 {
    public static void main(String[] args) throws IOException {
        int diceCount = 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n(보드의 크기) S(시작 시 가지는 돈) W(시작점 지날 때 받는 월급) G(황금 열쇠 개수)
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tk.nextToken());
        BigInteger S = new BigInteger(tk.nextToken());
        int W = Integer.parseInt(tk.nextToken());
        int G = Integer.parseInt(tk.nextToken());

        // 황금 열쇠 세팅
        Queue<String> goldenKey = new LinkedList<>();
        for(int i=0; i<G; i++) goldenKey.offer(br.readLine());

        // 보드 칸 세팅
        String[] board = new String[4*n - 4];
        ArrayList<Integer> building = new ArrayList<>(); // 빌딩 리스트
        for(int k=0; k<board.length; k++) {
            if(k % (n-1) == 0 || k % (2*n-2) == 0 || k % (3*n-3) == 0) continue; // 특수칸 건너뜀
            board[k] = br.readLine();

            // 빌딩 리스트 추가
            tk = new StringTokenizer(board[k], " ");
            if(tk.nextToken().equals("L")) building.add(k);
        }

        // 주사위 세팅
        int I = Integer.parseInt(br.readLine());
        int prePath = 0; // 이전 위치
        int currentPath = 0; // 현재 위치

        boolean island = false; // 무인도
        int islandCount = 0; // 무인도 횟수
        int social = 0; // 사회복지기금
        boolean golden4 = false; // 황금열쇠4번(y칸 앞으로)

        // 부루마블 시작
        for(int k=0; k<I; k++) {

            if(golden4) {
                golden4 = false;
                if(currentPath == 0) S = S.add(new BigInteger(String.valueOf(W)));
            } else {
                // 주사위 굴리기
                int[] dice = new int[diceCount];
                int diceSum = 0;
                tk = new StringTokenizer(br.readLine(), " ");
                for(int i=0; i<diceCount; i++) {
                    dice[i] = Integer.parseInt(tk.nextToken());
                    diceSum += dice[i];
                }

                // 무인도에 갇혀있을 경우
                if(island) {
                    if(dice[0] == dice[1]) {
                        island = false;
                        continue;
                    } else {
                        islandCount++;
                    }
                    // 무인도 3회가 지났을 경우
                    if(islandCount == 3) {
                        island = false;
                        islandCount = 0;
                    }
                    continue;
                }

                // 이동한 위치
                prePath = currentPath;
                // 시작칸이거나 시작칸을 지나갔을 경우
                if((prePath + diceSum) / board.length > 0 || currentPath == 0) S = S.add(new BigInteger(String.valueOf(W * ((prePath + diceSum) / board.length))));
                currentPath = (prePath + diceSum) % board.length;

                // System.out.print("칸 : " + currentPath + " ? " + dice[0] + " " + dice[1] + " - ");
            }

            // 시작 칸일 경우
            if (currentPath == 0) {}

            // 무인도 칸일 경우
            else if(currentPath == n-1) {
                island = true;
            }
            // 사회복지 칸일 경우
            else if(currentPath == 2*n-2) {
                S = S.add(new BigInteger(String.valueOf(social)));
                social = 0;
            }
            // 우주여행 칸일 경우
            else if(currentPath == 3*n-3) {
                currentPath = 0;
                S = S.add(new BigInteger(String.valueOf(W)));
            }
            // 일반칸일 경우
            else {
                tk = new StringTokenizer(board[currentPath], " ");
                String command = tk.nextToken();

                // 황금열쇠칸
                if(command.equals("G")) {
                    String goldenKeyItem = goldenKey.poll();
                    goldenKey.offer(goldenKeyItem);
                    tk = new StringTokenizer(goldenKeyItem, " ");
                    int goldenCommand = Integer.parseInt(tk.nextToken());
                    int p = Integer.parseInt(tk.nextToken());
                    switch(goldenCommand) {
                        case 1:
                            S = S.add(new BigInteger(String.valueOf(p)));
                            break;
                        case 2:
                            S = S.subtract(new BigInteger(String.valueOf(p)));
                            break;
                        case 3:
                            S = S.subtract(new BigInteger(String.valueOf(p)));
                            social += p;
                            break;
                        case 4:
                            golden4 = true;
                            // 시작칸이거나 시작칸을 지나갔을 경우
                            if((currentPath + p) / board.length > 0 || currentPath == 0) S = S.add(new BigInteger(String.valueOf(W * ((currentPath + p) / board.length))));
                            currentPath = (currentPath + p) % board.length;

                            k--;
                    }
                }
                // 일반 도시 칸
                else {
                    int p = Integer.parseInt(tk.nextToken());
                    // 빌딩을 구매할 돈이 있을 경우
                    if(S.compareTo(BigInteger.valueOf(p)) == 0 || S.compareTo(BigInteger.valueOf(p)) == 1) {
                        // 아직 구매하지 않은 빌딩일 경우
                        if(building.contains(new Integer(currentPath))) {
                            S = S.subtract(new BigInteger(String.valueOf(p)));
                            building.remove(new Integer(currentPath)); // 빌딩 구매
                        }
                    }
                }
            }

            //System.out.println("social : " + social + ", money : " + S);

            // 돈이 부족하여 LOSE
            if(S.compareTo(BigInteger.valueOf(0)) == -1) {
                bw.write("LOSE");
                bw.flush();
                return;
            }

        }

        // 턴 종료 후 확인
        if(building.size() > 0 || S.compareTo(BigInteger.valueOf(0)) == -1) {
            bw.write("LOSE");
        } else {
            bw.write("WIN");
        }
        bw.flush();
    }
}
