import java.io.*;

public class q11286 {
    static int naturalHeapSize = 0;
    static int unnaturalHeapSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] naturalHeap = new int[100000]; // 최소힙
        int[] unnaturalHeap = new int[100000]; // 최대힙

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input > 0) {
                insertNode(naturalHeap, unnaturalHeap, input, true);
            }
            else if(input < 0) {
                insertNode(naturalHeap, unnaturalHeap, input, false);
            }
            else bw.write(select(naturalHeap, unnaturalHeap) + "\n");
        }
        bw.flush();
    }

    public static void insertNode(int[] naturalHeap, int[] unnaturalHeap, int v, boolean isNatural) {
        // 값이 자연수일 경우
        if(isNatural) {
            // 말단 노드 삽입
            naturalHeap[++naturalHeapSize] = v;

            // 노드가 한 개일 경우 리턴
            if(naturalHeapSize == 1) return;
                // 노드가 여러 개일 경우
            else {
                // 현재 노드 인덱스
                int presentNodeIndex = naturalHeapSize;

                while(true) {
                    int parentNodeIndex  = presentNodeIndex / 2;
                    if(parentNodeIndex == 0) break;

                    if(naturalHeap[presentNodeIndex] < naturalHeap[parentNodeIndex]) {
                        swapNode(naturalHeap, presentNodeIndex, parentNodeIndex);
                        presentNodeIndex = parentNodeIndex;
                    } else {
                        break;
                    }
                }
            }
        }
        // 값이 자연수가 아닐 경우
        else {
            // 말단 노드 삽입
            unnaturalHeap[++unnaturalHeapSize] = v;

            // 노드가 한 개일 경우 리턴
            if(unnaturalHeapSize == 1) return;
                // 노드가 여러 개일 경우
            else {
                // 현재 노드 인덱스
                int presentNodeIndex = unnaturalHeapSize;

                while(true) {
                    int parentNodeIndex  = presentNodeIndex / 2;
                    if(parentNodeIndex == 0) break;

                    if(unnaturalHeap[presentNodeIndex] > unnaturalHeap[parentNodeIndex]) {
                        swapNode(unnaturalHeap, presentNodeIndex, parentNodeIndex);
                        presentNodeIndex = parentNodeIndex;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static int select(int[] naturalHeap, int[] unnaturalHeap) {
        int rootNode = 0;
        int naturalHeapRoot;
        int unnaturalHeapRoot;

        if(naturalHeapSize == 0) naturalHeapRoot = 0;
        else naturalHeapRoot = naturalHeap[1];

        if(unnaturalHeapSize == 0) unnaturalHeapRoot = 0;
        else unnaturalHeapRoot = unnaturalHeap[1];

        // 두 힙이 비어있을 경우
        if(naturalHeapRoot == 0 && unnaturalHeapRoot == 0) rootNode = 0;
        // 자연수 힙이 비어있을 경우 => 음수 힙
        else if(naturalHeapRoot == 0) {
            rootNode = unnaturalHeapRoot;
            popUnnaturalRoot(unnaturalHeap);
        }
        // 음수 힙이 비어있을 경우 => 자연수 힙
        else if(unnaturalHeapRoot == 0) {
            rootNode = naturalHeapRoot;
            popNaturalRoot(naturalHeap);
        }
        // 둘 중에 절댓값이 더 작은 것
        else {
            // 자연수의 절댓값이 더 작을 경우 => 자연수 힙
            if(Math.abs(naturalHeapRoot) < Math.abs(unnaturalHeapRoot)) {
                rootNode = naturalHeapRoot;
                popNaturalRoot(naturalHeap);
            }
            // 음수의 절댓값이 더 작거나 같을 경우 => 음수 힙
            else {
                rootNode = unnaturalHeapRoot;
                popUnnaturalRoot(unnaturalHeap);
            }
        }
        return rootNode;
    }

    public static int popNaturalRoot(int[] naturalHeap) {
        int rootNode = naturalHeap[1];
        naturalHeap[1] = naturalHeap[naturalHeapSize--];
        int presentNodeIndex = 1;

        while(true) {
            int childNodeIndex1 = presentNodeIndex * 2;
            int childNodeIndex2 = presentNodeIndex * 2 + 1;
            int changeNodeIndex;

            // 자식이 없을 경우
            if(childNodeIndex1 > naturalHeapSize) break;
            // 자식이 하나일 경우
            if(childNodeIndex2 > naturalHeapSize) {
                changeNodeIndex = childNodeIndex1;
            }
            // 자식이 둘일 경우
            else {
                if(naturalHeap[childNodeIndex1] < naturalHeap[childNodeIndex2]) changeNodeIndex = childNodeIndex1;
                else changeNodeIndex = childNodeIndex2;
            }

            // 현재노드(부모)가 자식보다 클 경우 값 교환
            if(naturalHeap[presentNodeIndex] > naturalHeap[changeNodeIndex]) {
                swapNode(naturalHeap, presentNodeIndex, changeNodeIndex);
                presentNodeIndex = changeNodeIndex;
            } else {
                break;
            }
        }
        return rootNode;
    }

    public static int popUnnaturalRoot(int[] unnaturalHeap) {
        int rootNode = unnaturalHeap[1];
        unnaturalHeap[1] = unnaturalHeap[unnaturalHeapSize--];
        int presentNodeIndex = 1;

        while(true) {
            int childNodeIndex1 = presentNodeIndex * 2;
            int childNodeIndex2 = presentNodeIndex * 2 + 1;
            int changeNodeIndex;

            // 자식이 없을 경우
            if(childNodeIndex1 > unnaturalHeapSize) break;
            // 자식이 하나일 경우
            if(childNodeIndex2 > unnaturalHeapSize) {
                changeNodeIndex = childNodeIndex1;
            }
            // 자식이 둘일 경우
            else {
                if(unnaturalHeap[childNodeIndex1] > unnaturalHeap[childNodeIndex2]) changeNodeIndex = childNodeIndex1;
                else changeNodeIndex = childNodeIndex2;
            }

            // 현재노드(부모)가 자식보다 클 경우 값 교환
            if(unnaturalHeap[presentNodeIndex] < unnaturalHeap[changeNodeIndex]) {
                swapNode(unnaturalHeap, presentNodeIndex, changeNodeIndex);
                presentNodeIndex = changeNodeIndex;
            } else {
                break;
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
