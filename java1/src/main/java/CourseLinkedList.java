import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseLinkedList {
    public static void main(String[] args) {
        LinkedList<String> course = new LinkedList<>();
        course.add("văn");
        course.add("sử");
        course.add("địa");
//      for (int i = 0; i < students.size(); i++) {
//          System.out.println(i + 1 + ". " + students.get(i));
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n ===== MENU =====");
                System.out.println("1. Thêm khóa học");
                System.out.println("2. Sửa khóa học");
                System.out.println("3. Xóa khóa học");
                System.out.println("4. Hiển thị danh sách khóa học");
                System.out.println("5. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = sc.nextInt();
                sc.nextLine(); // tránh dòng trống sau số
                switch (choice) {
                    case 1:
                        // thêm khóa học
                        System.out.println("Nhập tên khóa học: ");
                        String CourseName = sc.nextLine();
                        course.addFirst(CourseName);
                        System.out.println("Đã thêm khóa học " + CourseName + " vào danh sách");
                        break;
                    case 2:
                        // sửa khóa học
                        if (course.isEmpty()) {
                            System.out.println("Danh sách khóa học trống rỗng!");
                        } else {
                            System.out.println("Danh sách khóa học: ");
                            for (int i = 0; i < course.size(); i++) {
                                System.out.println(i + 1 + ". " + course.get(i));
                            }
                        }
                        System.out.println("Nhập số thứ tự khóa học cần sửa: ");
                        int indexToEdit = sc.nextInt() - 1;
                        sc.nextLine();
                        if (indexToEdit >= 0 && indexToEdit < course.size()) {
                            System.out.println("Nhập tên khóa học mới: ");
                            String suaCourseName = sc.nextLine();
                            course.set(indexToEdit, suaCourseName);
                            System.out.println("Đã sửa vị trí khóa học " + (indexToEdit + 1) + " thành " + suaCourseName);
                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }
                        break;
                    case 3:
                        // xóa khóa học
                        if (course.isEmpty()) {
                            System.out.println("Danh sách khóa học trống rỗng!");
                        } else {
                            System.out.println("Danh sách khóa học: ");
                            for (int i = 0; i < course.size(); i++) {
                                System.out.println(i + 1 + ". " + course.get(i));
                            }
                        }
                        System.out.println("Nhập số thứ tự khóa học cần xóa: ");
                        int indexToDelete = sc.nextInt() - 1;
                        sc.nextLine(); // thêm dòng này để xuống dòng
                        if (indexToDelete >= 0 && indexToDelete < course.size()) {
                            String xoaCourseName = course.remove(indexToDelete);
                            System.out.println("Đã xóa khóa học " + xoaCourseName);
                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }
                        break;
                    case 4:
                        // hiển thị danh sách khóa học
                        if (course.isEmpty()) {
                            System.out.println("Danh sách khóa học trống rỗng!");
                        } else {
                            System.out.println("Danh sách khóa học: ");
                            for (int i = 0; i < course.size(); i++) {
                                System.out.println(i + 1 + ". " + course.get(i));
                            }
                        }
                        break;
                    case 5:
                        // thoát
                        System.out.println("Thoát chương trình...");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số từ 1 đến 5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                sc.nextLine(); // Đọc dòng trống để tránh lặp vô hạn
            }
        }
    }
}
