import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentsArrayList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("vusena");
        students.add("huy");
        students.add("van");
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n ===== MENU =====");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Sửa sinh viên");
                System.out.println("3. Xóa sinh viên");
                System.out.println("4. Hiển thị danh sách sinh viên");
                System.out.println("5. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = sc.nextInt();
                sc.nextLine(); // tránh dòng trống sau số
                switch (choice) {
                    case 1:
                        // thêm sinh viên
                        System.out.println("Nhập tên sinh viên cần thêm");
                        String name = sc.nextLine();
                        students.add(name);
                        System.out.println("Đã thêm sinh viên " + name + " vào danh sách");
                        break;
                    case 2:
                        // sửa sinh viên
                        if (students.isEmpty()) {
                            System.out.println("Danh sách sinh viên trống rỗng!");
                        } else {
                            System.out.println("Danh sách sinh viên: ");
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println(i + 1 + ". " + students.get(i));
                            }
                        }
                        System.out.println("Nhập số thứ tự sinh viên cần sửa ");
                        int indexToEdit = sc.nextInt() - 1;// Chuyển từ 1-based sang 0-based
                        sc.nextLine();
                        if (indexToEdit >= 0 && indexToEdit < students.size()) {
                            System.out.println("Nhập tên sinh viên mới: ");
                            String suaStudentName = sc.nextLine();
                            students.set(indexToEdit, suaStudentName);
                            System.out.println("Đã sửa sinh viên tại vị trí " + (indexToEdit + 1) + " thành " + suaStudentName);
                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }
                        break;
                    case 3:
                        // xóa sinh viên
                        if (students.isEmpty()) {
                            System.out.println("Danh sách sinh viên trống rỗng!");
                        } else {
                            System.out.println("Danh sách sinh viên: ");
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println(i + 1 + ". " + students.get(i));
                            }
                        }
                        System.out.println("Nhập số thứ tự sinh viên cần xóa ");
                        int indexToDelete = sc.nextInt() - 1;// Chuyển từ 1-based sang 0-based
                        sc.nextLine();
                        if (indexToDelete >= 0 && indexToDelete < students.size()) {
                            String xoaStudentName = students.remove(indexToDelete);
                            System.out.println("Đã xóa sinh viên " + xoaStudentName);
                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }
                        break;
                    case 4:
                        // Hiển thị danh sách sinh viên
                        if (students.isEmpty()) {
                            System.out.println("Danh sách sinh viên trống rỗng!");
                        } else {
                            System.out.println("Danh sách sinh viên: ");
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println(i + 1 + ". " + students.get(i));
                            }
                        }
                        break;
                    case 5:
                        // Thoát
                        System.out.println("Thoát chương trình.");
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
