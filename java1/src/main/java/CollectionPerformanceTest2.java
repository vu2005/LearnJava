
import java.util.*;

public class CollectionPerformanceTest2 {

    private static final int N = 50000;          // Số phần tử để test chèn (insertion)
    private static final int GET_TEST_COUNT = 10000;  // Số lần test tìm kiếm ngẫu nhiên

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MENU SO SÁNH HIỆU NĂNG COLLECTION =====");
            System.out.println("1. So sánh List (ArrayList, LinkedList)");
            System.out.println("2. So sánh Set (HashSet, LinkedHashSet, TreeSet)");
            System.out.println("3. So sánh Map (HashMap, LinkedHashMap, TreeMap)");
            System.out.println("4. So sánh Queue (PriorityQueue vs LinkedList-as-Queue)");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    compareLists();
                    break;
                case 2:
                    compareSets();
                    break;
                case 3:
                    compareMaps();
                    break;
                case 4:
                    compareQueues();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }

        scanner.close();
    }

    // ==================================================
    // 1. So sánh List: ArrayList vs LinkedList
    // ==================================================
    private static void compareLists() {
        System.out.println("\n=== SO SÁNH LIST: ArrayList vs LinkedList ===");

        // -----------------------------
        // 1) Test chèn N phần tử
        // -----------------------------
        long start = System.nanoTime();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
        }
        long end = System.nanoTime();
        long arrayListInsertionTime = end - start;

        start = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            linkedList.add(i);
        }
        end = System.nanoTime();
        long linkedListInsertionTime = end - start;

        // -----------------------------
        // 2) Test get() ngẫu nhiên GET_TEST_COUNT lần
        // -----------------------------
        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int index = (int) (Math.random() * N);
            arrayList.get(index);
        }
        end = System.nanoTime();
        long arrayListGetTime = end - start;

        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int index = (int) (Math.random() * N);
            linkedList.get(index);
        }
        end = System.nanoTime();
        long linkedListGetTime = end - start;

        // -----------------------------
        // 3) Test duyệt (iteration)
        // -----------------------------
        start = System.nanoTime();
        for (Integer val : arrayList) {
            // Không làm gì
        }
        end = System.nanoTime();
        long arrayListIterTime = end - start;

        start = System.nanoTime();
        for (Integer val : linkedList) {
            // Không làm gì
        }
        end = System.nanoTime();
        long linkedListIterTime = end - start;

        // -----------------------------
        // In kết quả
        // -----------------------------
        System.out.println("[Insertion]  ArrayList: " + arrayListInsertionTime + " ns, "
                + "LinkedList: " + linkedListInsertionTime + " ns");
        System.out.println("[Get random] ArrayList: " + arrayListGetTime + " ns, "
                + "LinkedList: " + linkedListGetTime + " ns");
        System.out.println("[Iteration]  ArrayList: " + arrayListIterTime + " ns, "
                + "LinkedList: " + linkedListIterTime + " ns");

        System.out.println("\n--- Nhận xét nhanh ---");
        System.out.println("* ArrayList: Chèn cuối nhanh, get(index) nhanh O(1), "
                + "nhưng thêm/xoá giữa/đầu chậm.");
        System.out.println("* LinkedList: get(index) chậm O(n), thêm/xoá đầu/cuối O(1), "
                + "phù hợp làm Queue/Deque.");
    }

    // ==================================================
    // 2. So sánh Set: HashSet, LinkedHashSet, TreeSet
    // ==================================================
    private static void compareSets() {
        System.out.println("\n=== SO SÁNH SET: HashSet vs LinkedHashSet vs TreeSet ===");

        // --- Chuẩn bị 3 Set ---
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        // -----------------------------
        // 1) Test chèn N phần tử
        // -----------------------------
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            hashSet.add(i);
        }
        long end = System.nanoTime();
        long hashSetInsert = end - start;

        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            linkedHashSet.add(i);
        }
        end = System.nanoTime();
        long linkedHashSetInsert = end - start;

        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            treeSet.add(i);
        }
        end = System.nanoTime();
        long treeSetInsert = end - start;

        // -----------------------------
        // 2) Test contains() ngẫu nhiên GET_TEST_COUNT lần
        // -----------------------------
        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int val = (int) (Math.random() * N);
            hashSet.contains(val);
        }
        end = System.nanoTime();
        long hashSetContains = end - start;

        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int val = (int) (Math.random() * N);
            linkedHashSet.contains(val);
        }
        end = System.nanoTime();
        long linkedHashSetContains = end - start;

        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int val = (int) (Math.random() * N);
            treeSet.contains(val);
        }
        end = System.nanoTime();
        long treeSetContains = end - start;

        // -----------------------------
        // 3) Duyệt (iteration)
        // -----------------------------
        start = System.nanoTime();
        for (Integer val : hashSet) { }
        end = System.nanoTime();
        long hashSetIter = end - start;

        start = System.nanoTime();
        for (Integer val : linkedHashSet) { }
        end = System.nanoTime();
        long linkedHashSetIter = end - start;

        start = System.nanoTime();
        for (Integer val : treeSet) { }
        end = System.nanoTime();
        long treeSetIter = end - start;

        // -----------------------------
        // In kết quả
        // -----------------------------
        System.out.println("[Insertion]      HashSet: " + hashSetInsert + " ns, "
                + "LinkedHashSet: " + linkedHashSetInsert + " ns, "
                + "TreeSet: " + treeSetInsert + " ns");
        System.out.println("[Contains]       HashSet: " + hashSetContains + " ns, "
                + "LinkedHashSet: " + linkedHashSetContains + " ns, "
                + "TreeSet: " + treeSetContains + " ns");
        System.out.println("[Iteration]      HashSet: " + hashSetIter + " ns, "
                + "LinkedHashSet: " + linkedHashSetIter + " ns, "
                + "TreeSet: " + treeSetIter + " ns");

        System.out.println("\n--- Nhận xét nhanh ---");
        System.out.println("* HashSet:     Không thứ tự, thêm/kiểm tra trung bình O(1).");
        System.out.println("* LinkedHashSet: Duy trì thứ tự chèn, tốc độ trung bình gần HashSet.");
        System.out.println("* TreeSet:     Sắp xếp tự nhiên, thêm/kiểm tra O(log n).");
    }

    // ==================================================
    // 3. So sánh Map: HashMap, LinkedHashMap, TreeMap
    // ==================================================
    private static void compareMaps() {
        System.out.println("\n=== SO SÁNH MAP: HashMap vs LinkedHashMap vs TreeMap ===");

        // --- Chuẩn bị 3 Map ---
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        // -----------------------------
        // 1) Test put() N phần tử
        // -----------------------------
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            hashMap.put(i, i);
        }
        long end = System.nanoTime();
        long hashMapInsert = end - start;

        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            linkedHashMap.put(i, i);
        }
        end = System.nanoTime();
        long linkedHashMapInsert = end - start;

        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            treeMap.put(i, i);
        }
        end = System.nanoTime();
        long treeMapInsert = end - start;

        // -----------------------------
        // 2) Test get() ngẫu nhiên GET_TEST_COUNT lần
        // -----------------------------
        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int key = (int) (Math.random() * N);
            hashMap.get(key);
        }
        end = System.nanoTime();
        long hashMapGet = end - start;

        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int key = (int) (Math.random() * N);
            linkedHashMap.get(key);
        }
        end = System.nanoTime();
        long linkedHashMapGet = end - start;

        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int key = (int) (Math.random() * N);
            treeMap.get(key);
        }
        end = System.nanoTime();
        long treeMapGet = end - start;

        // -----------------------------
        // 3) Duyệt entrySet
        // -----------------------------
        start = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) { }
        end = System.nanoTime();
        long hashMapIter = end - start;

        start = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) { }
        end = System.nanoTime();
        long linkedHashMapIter = end - start;

        start = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) { }
        end = System.nanoTime();
        long treeMapIter = end - start;

        // -----------------------------
        // In kết quả
        // -----------------------------
        System.out.println("[Insertion put]  HashMap: " + hashMapInsert + " ns, "
                + "LinkedHashMap: " + linkedHashMapInsert + " ns, "
                + "TreeMap: " + treeMapInsert + " ns");
        System.out.println("[Get random]     HashMap: " + hashMapGet + " ns, "
                + "LinkedHashMap: " + linkedHashMapGet + " ns, "
                + "TreeMap: " + treeMapGet + " ns");
        System.out.println("[Iteration]      HashMap: " + hashMapIter + " ns, "
                + "LinkedHashMap: " + linkedHashMapIter + " ns, "
                + "TreeMap: " + treeMapIter + " ns");

        System.out.println("\n--- Nhận xét nhanh ---");
        System.out.println("* HashMap:       Không thứ tự, trung bình O(1) cho put/get.");
        System.out.println("* LinkedHashMap: Giữ thứ tự chèn, tốc độ gần HashMap nhưng tốn thêm chi phí liên kết.");
        System.out.println("* TreeMap:       Sắp xếp key, put/get O(log n), hỗ trợ range-query, duyệt theo key tăng dần.");
    }

    // ==================================================
    // 4. So sánh Queue: PriorityQueue vs LinkedList (as Queue)
    // ==================================================
    private static void compareQueues() {
        System.out.println("\n=== SO SÁNH QUEUE: PriorityQueue vs LinkedList-as-Queue ===");

        // PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // LinkedList as a Queue
        Queue<Integer> linkedListQueue = new LinkedList<>();

        // -----------------------------
        // 1) Test offer (chèn) N phần tử
        // -----------------------------
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer((int) (Math.random() * N));
        }
        long end = System.nanoTime();
        long pqInsertion = end - start;

        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            linkedListQueue.offer((int) (Math.random() * N));
        }
        end = System.nanoTime();
        long llqInsertion = end - start;

        // -----------------------------
        // 2) Test poll (lấy/ xóa phần tử đầu queue) N lần
        // -----------------------------
        start = System.nanoTime();
        while (!priorityQueue.isEmpty()) {
            priorityQueue.poll();
        }
        end = System.nanoTime();
        long pqPoll = end - start;

        start = System.nanoTime();
        while (!linkedListQueue.isEmpty()) {
            linkedListQueue.poll();
        }
        end = System.nanoTime();
        long llqPoll = end - start;

        // -----------------------------
        // In kết quả
        // -----------------------------
        System.out.println("[Offer (enqueue)] PriorityQueue: " + pqInsertion + " ns, "
                + "LinkedList: " + llqInsertion + " ns");
        System.out.println("[Poll (dequeue)]  PriorityQueue: " + pqPoll + " ns, "
                + "LinkedList: " + llqPoll + " ns");

        System.out.println("\n--- Nhận xét nhanh ---");
        System.out.println("* PriorityQueue: Luôn duy trì thứ tự ưu tiên (min-heap mặc định), "
                + "thêm/poll O(log n) trung bình.");
        System.out.println("* LinkedList-as-Queue: FIFO đơn thuần, offer/poll O(1) trung bình.");
    }
}
