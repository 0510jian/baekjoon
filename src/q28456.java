import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class q28456 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Deque[] array = new Deque[N];
        for(int i=0; i<N; i++) {
            array[i] = new LinkedList();
            for(int j=0; j<N; j++) {
                array[i].addLast(sc.nextInt());
            }
        }

        int Q = sc.nextInt();
        for(int a=0; a<Q; a++) {
            int command = sc.nextInt();

            switch(command) {
                case 1 :
                    int I = sc.nextInt() - 1;
                    array[I].addFirst(array[I].pollLast());
                    break;
                case 2:
                    Deque[] arrayTemp = new Deque[N];
                    for(int b=0; b<N; b++) {
                        arrayTemp[b] = new LinkedList();
                    }
                    for(int i=0; i<N; i++) {
                        for(int j=0; j<N; j++) {
                            arrayTemp[j].addFirst(array[i].pollFirst());
                        }
                    }
                    array = arrayTemp;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(array[i].pollFirst() + " ");
            }
            System.out.println();
        }
    }
}
