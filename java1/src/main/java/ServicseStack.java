import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class ServicseStack {
    public static void main(String[] args) {
        Stack<String> servicse = new Stack<>();
        servicse.add("du lịch");
        servicse.add("bán nhà");
        servicse.add("xây nhà");
        for (int i = 0; i < servicse.size(); i++) {
            System.out.println(i + 1 + ". " + servicse.get(i));
        }
        Scanner sc = new Scanner(System.in);
        while (true) {

            try {
                System.out.println("\n ===== MENU =====");
                System.out.println("1. Thêm dịch vụ");
                System.out.println("2. Sửa dịch vụ");
                System.out.println("3. Xóa dịch vụ");
                System.out.println("4. Hiển thị danh sách dịch vụ");
                System.out.println("5. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //thêm dịch vụ
                        System.out.println("Nhập tên dịch vụ: ");
                        String serviceName = sc.nextLine();
                        servicse.add(serviceName);
                        System.out.println("Đã thêm dịch vụ: " + serviceName + " vào danh sách");
                        break;
                    case 2:
                        //Sửa dịch vụ
                        if (servicse.isEmpty()) {
                            System.out.println("Danh sách dịch vụ trống rỗng!");
                        } else {
                            System.out.println("Danh sách dịch vụ: ");
                            for (int i = 0; i < servicse.size(); i++) {
                                System.out.println(i + 1 + ". " + servicse.get(i));
                            }
                        }
                        System.out.println("Nhập số dịch vụ mà bạn muốn sửa: ");
                        int IndexToEdit = sc.nextInt() - 1;
                        sc.nextLine(); // thiếu dòng này sẽ gây lỗi không thể thiếu
                        if (IndexToEdit >= 0 && IndexToEdit < servicse.size()) {
                            System.out.println("Nhập tên dịch vụ mới: ");
                            String suaServicseName = sc.nextLine();
                            servicse.set(IndexToEdit, suaServicseName);
                            System.out.println("Vị trí đã được sửa ở " + IndexToEdit + " thành " + suaServicseName);
                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }
                        break;
                    case 3:
                        // xóa dịch vụ
                        if (servicse.isEmpty()) {
                            System.out.println("Danh sách dịch vụ trống rỗng!");
                        } else {
                            System.out.println("Danh sách dịch vụ: ");
                            for (int i = 0; i < servicse.size(); i++) {
                                System.out.println(i + 1 + ". " + servicse.get(i));
                            }
                        }
                        System.out.println("Nhập số dịch vụ mà bạn muốn xóa: ");
                        int IndexToDetele = sc.nextInt() - 1;
                        sc.nextLine();
                        if (IndexToDetele >= 0 && IndexToDetele < servicse.size()) {
                            String DeteleServicseName = servicse.remove(IndexToDetele);
                            System.out.println("Đã xóa dịch vụ: " + DeteleServicseName);
                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }
                        break;
                    case 4:
                        if (servicse.isEmpty()) {
                            System.out.println("Danh sách dịch vụ trống rỗng!");
                        } else {
                            System.out.println("Danh sách dịch vụ: ");
                            for (int i = 0; i < servicse.size(); i++) {
                                System.out.println(i + 1 + ". " + servicse.get(i));
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
                System.out.println("Lỗi: vui lòng nhập số!: ");
                sc.nextLine();
            }
        }
    }
}
