import java.io.*;

public class q1927 {
    static int heapSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] minHeap = new int[100000];

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input > 0) insertNode(minHeap, input);
            else if(input == 0) bw.write(popRoot(minHeap)+"\n");
        }
        bw.flush();
    }

    public static void insertNode(int[] minHeap, int v) {
        // 말단 노드 삽입
        minHeap[++heapSize] = v;

        // 노드가 한 개일 경우 리턴
        if(heapSize == 1) return;
        // 노드가 여러 개일 경우
        else {
            // 현재 노드 인덱스
            int presentNodeIndex = heapSize;

            while(true) {
                int parentNodeIndex  = presentNodeIndex / 2;
                if(parentNodeIndex == 0) return;

                if(minHeap[presentNodeIndex] < minHeap[parentNodeIndex]) {
                    swapNode(minHeap, presentNodeIndex, parentNodeIndex);
                    presentNodeIndex = parentNodeIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static int popRoot(int[] minHeap) {
        int rootNode = 0;

        // 힙이 비어있을 경우
        if(heapSize == 0) return rootNode;
        // 합이 비어있지 않을 경우
        else {
            rootNode = minHeap[1];
            minHeap[1] = minHeap[heapSize--];
            int presentNodeIndex = 1;

            while(true) {
                int childNodeIndex1 = presentNodeIndex * 2;
                int childNodeIndex2 = presentNodeIndex * 2 + 1;
                int changeNodeIndex;

                // 자식이 없을 경우
                if(childNodeIndex1 > heapSize) break;
                // 자식이 하나일 경우
                if(childNodeIndex2 > heapSize) {
                    changeNodeIndex = childNodeIndex1;
                }
                // 자식이 둘일 경우
                else {
                    if(minHeap[childNodeIndex1] < minHeap[childNodeIndex2]) changeNodeIndex = childNodeIndex1;
                    else changeNodeIndex = childNodeIndex2;
                }

                // 현재노드(부모)가 자식보다 클 경우 값 교환
                if(minHeap[presentNodeIndex] > minHeap[changeNodeIndex]) {
                    swapNode(minHeap, presentNodeIndex, changeNodeIndex);
                    presentNodeIndex = changeNodeIndex;
                } else {
                    break;
                }
            }
        }
        return rootNode;
    }

    public static void swapNode(int[] minHeap, int aNodeIndex, int bNodeIndex) {
        int tempV = minHeap[aNodeIndex];
        minHeap[aNodeIndex] = minHeap[bNodeIndex];
        minHeap[bNodeIndex] = tempV;
    }
}
