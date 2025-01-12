
import java.util.*;

public class CollectionPerformanceTest {

    private static final int N = 100000; // Số phần tử muốn test
    private static final int GET_TEST_COUNT = 100000; // Số lần get/search để test

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MENU SO SÁNH HIỆU NĂNG COLLECTION =====");
            System.out.println("1. Test hiệu năng List (ArrayList vs LinkedList)");
            System.out.println("2. Test hiệu năng Set (HashSet vs TreeSet)");
            System.out.println("3. Test hiệu năng Map (HashMap vs TreeMap)");
            System.out.println("4. Thoát");
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
                    testListPerformance();
                    break;
                case 2:
                    testSetPerformance();
                    break;
                case 3:
                    testMapPerformance();
                    break;
                case 4:
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

    // --------------------------------------------------------------------
    // 1) Test hiệu năng List: ArrayList vs LinkedList
    // --------------------------------------------------------------------
    private static void testListPerformance() {
        System.out.println("=== TEST HIỆU NĂNG List (ArrayList vs LinkedList) ===");

        // 1. Thêm N phần tử (insertion)
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

        // 2. Truy cập ngẫu nhiên GET_TEST_COUNT lần
        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            // Lấy ngẫu nhiên 1 vị trí
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

        // 3. Duyệt phần tử (iteration)
        start = System.nanoTime();
        for (Integer val : arrayList) {
            // Không làm gì, chỉ duyệt
        }
        end = System.nanoTime();
        long arrayListIterTime = end - start;

        start = System.nanoTime();
        for (Integer val : linkedList) {
            // Không làm gì, chỉ duyệt
        }
        end = System.nanoTime();
        long linkedListIterTime = end - start;

        // In kết quả
        System.out.println("\n[Insertion] ArrayList: " + arrayListInsertionTime + " ns, "
                + "LinkedList: " + linkedListInsertionTime + " ns");
        System.out.println("[Get random] ArrayList: " + arrayListGetTime + " ns, "
                + "LinkedList: " + linkedListGetTime + " ns");
        System.out.println("[Iteration] ArrayList: " + arrayListIterTime + " ns, "
                + "LinkedList: " + linkedListIterTime + " ns");

        // Gợi ý nhận xét
        System.out.println("\n* Nhận xét List:");
        System.out.println("- ArrayList thường thêm cuối nhanh, truy cập ngẫu nhiên nhanh O(1).");
        System.out.println("- LinkedList phù hợp thêm / xóa ở đầu/cuối O(1), nhưng get(index) chậm O(n).");
    }

    // --------------------------------------------------------------------
    // 2) Test hiệu năng Set: HashSet vs TreeSet
    // --------------------------------------------------------------------
    private static void testSetPerformance() {
        System.out.println("=== TEST HIỆU NĂNG Set (HashSet vs TreeSet) ===");

        // 1. Thêm N phần tử
        long start = System.nanoTime();
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(i);
        }
        long end = System.nanoTime();
        long hashSetInsertionTime = end - start;

        start = System.nanoTime();
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            treeSet.add(i);
        }
        end = System.nanoTime();
        long treeSetInsertionTime = end - start;

        // 2. Kiểm tra contains ngẫu nhiên GET_TEST_COUNT lần
        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int value = (int) (Math.random() * N);
            hashSet.contains(value);
        }
        end = System.nanoTime();
        long hashSetContainsTime = end - start;

        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int value = (int) (Math.random() * N);
            treeSet.contains(value);
        }
        end = System.nanoTime();
        long treeSetContainsTime = end - start;

        // 3. Duyệt phần tử (iteration)
        start = System.nanoTime();
        for (Integer val : hashSet) {
            // Không làm gì
        }
        end = System.nanoTime();
        long hashSetIterTime = end - start;

        start = System.nanoTime();
        for (Integer val : treeSet) {
            // Không làm gì
        }
        end = System.nanoTime();
        long treeSetIterTime = end - start;

        // In kết quả
        System.out.println("\n[Insertion] HashSet: " + hashSetInsertionTime + " ns, "
                + "TreeSet: " + treeSetInsertionTime + " ns");
        System.out.println("[Contains] HashSet: " + hashSetContainsTime + " ns, "
                + "TreeSet: " + treeSetContainsTime + " ns");
        System.out.println("[Iteration] HashSet: " + hashSetIterTime + " ns, "
                + "TreeSet: " + treeSetIterTime + " ns");

        // Gợi ý nhận xét
        System.out.println("\n* Nhận xét Set:");
        System.out.println("- HashSet trung bình O(1) với thêm, xóa, contains.");
        System.out.println("- TreeSet có thứ tự, hỗ trợ sắp xếp, nhưng thêm, contains O(log n).");
    }

    // --------------------------------------------------------------------
    // 3) Test hiệu năng Map: HashMap vs TreeMap
    // --------------------------------------------------------------------
    private static void testMapPerformance() {
        System.out.println("=== TEST HIỆU NĂNG Map (HashMap vs TreeMap) ===");

        // 1. Thêm N cặp key-value
        long start = System.nanoTime();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hashMap.put(i, i);
        }
        long end = System.nanoTime();
        long hashMapInsertionTime = end - start;

        start = System.nanoTime();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            treeMap.put(i, i);
        }
        end = System.nanoTime();
        long treeMapInsertionTime = end - start;

        // 2. Tìm kiếm (get) ngẫu nhiên GET_TEST_COUNT lần
        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int key = (int) (Math.random() * N);
            hashMap.get(key);
        }
        end = System.nanoTime();
        long hashMapGetTime = end - start;

        start = System.nanoTime();
        for (int i = 0; i < GET_TEST_COUNT; i++) {
            int key = (int) (Math.random() * N);
            treeMap.get(key);
        }
        end = System.nanoTime();
        long treeMapGetTime = end - start;

        // 3. Duyệt phần tử entrySet
        start = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            // Không làm gì
        }
        end = System.nanoTime();
        long hashMapIterTime = end - start;

        start = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            // Không làm gì
        }
        end = System.nanoTime();
        long treeMapIterTime = end - start;

        // In kết quả
        System.out.println("\n[Insertion] HashMap: " + hashMapInsertionTime + " ns, "
                + "TreeMap: " + treeMapInsertionTime + " ns");
        System.out.println("[Get random] HashMap: " + hashMapGetTime + " ns, "
                + "TreeMap: " + treeMapGetTime + " ns");
        System.out.println("[Iteration] HashMap: " + hashMapIterTime + " ns, "
                + "TreeMap: " + treeMapIterTime + " ns");

        // Gợi ý nhận xét
        System.out.println("\n* Nhận xét Map:");
        System.out.println("- HashMap: Thêm, get trung bình O(1), không có thứ tự key.");
        System.out.println("- TreeMap: Thêm, get O(log n), có sắp xếp key theo thứ tự tự nhiên.");
    }
}
