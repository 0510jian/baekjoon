import java.io.*;

public class q11279 {
    static int heapSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] maxHeap = new int[100000];
        maxHeap[0] = 0;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input > 0) insertNode(maxHeap, input);
            else if(input == 0) bw.write(popRoot(maxHeap)+"\n");
        }
        bw.flush();
    }

    // 삽입 연산
    public static void insertNode(int[] maxHeap, int v) {

        // 단말 노드 삽입
        maxHeap[++heapSize] = v;

        // 최대힙이 비어있었을 경우 리턴(비어있다 1개 추가돼서 1일 때 리턴)
        if(heapSize == 1) return;

        // 최대힙이 비어있지 않을 경우 자리 교환
        else {
            // 현재 노드 인덱스
            int presentNodeIndex = heapSize;

            while(true) {
                int parentNodeIndex = presentNodeIndex / 2;
                if(parentNodeIndex == 0) break;

                // 현재노드(자식)가 부모노드보다 클 경우 값 교환
                if(maxHeap[presentNodeIndex] > maxHeap[parentNodeIndex]) {
                    swapNode(maxHeap, presentNodeIndex, parentNodeIndex);
                    presentNodeIndex = parentNodeIndex; // 바뀐 인덱스 수정
                } else {
                    break;
                }
            }
        }
    }

    // 삭제 연산
    public static int popRoot(int[] maxHeap) {
        int rootNode = 0;

        // 힙이 비었을 경우
        if(heapSize == 0) return rootNode;

        // 힙이 비어있지 않을 경우
        else {
            // 루트 노드
            rootNode = maxHeap[1];

            // 단말 노드를 루트 노드로 옮김
            maxHeap[1] = maxHeap[heapSize--];

            int presentNodeIndex = 1;

            while (true) {
                // 자식 노드 중 더 큰 자식 선택
                int childNodeIndex1 = presentNodeIndex*2;
                int childNodeIndex2 = presentNodeIndex*2+1;
                int changeNodeIndex;

                // 자식노드가 없을 경우
                if(childNodeIndex1 > heapSize) break;
                // 자식노드가 한 개일 경우
                if(childNodeIndex2 > heapSize) {
                    changeNodeIndex = childNodeIndex1;
                }
                // 자식노드가 두 개일 경우
                else {
                    if(maxHeap[childNodeIndex1] > maxHeap[childNodeIndex2]) changeNodeIndex = childNodeIndex1;
                    else changeNodeIndex = childNodeIndex2;
                }

                // 현재노드(부모)가 자식노드보다 작을 경우 값 교환
                if(maxHeap[presentNodeIndex] < maxHeap[changeNodeIndex]) {
                    swapNode(maxHeap, presentNodeIndex, changeNodeIndex);
                    presentNodeIndex = changeNodeIndex;
                } else {
                    break;
                }
            }
        }
        return rootNode;
    }

    public static void swapNode(int[] maxHeap, int aNodeIndex, int bNodeIndex) {
        int tempV = maxHeap[aNodeIndex];
        maxHeap[aNodeIndex] = maxHeap[bNodeIndex];
        maxHeap[bNodeIndex] = tempV;
    }
}
