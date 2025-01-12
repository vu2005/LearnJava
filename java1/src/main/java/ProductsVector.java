import java.util.Scanner;
import java.util.Vector;

public class ProductsVector {
    public static void main(String[] args) {
        Vector<String> products = new Vector<>();
        products.add("Apple");
        products.add("Banana");
        products.add("Orange");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + ". " + products.get(i));
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n ===== MENU =====");
                System.out.println("1. Thêm sản phẩm");
                System.out.println("2. Sửa sản phẩm");
                System.out.println("3. Xóa sản phẩm");
                System.out.println("4. Hiển thị danh sách sản phẩm");
                System.out.println("5. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //thêm sản phẩm
                        System.out.println("Nhập tên sản phẩm: ");
                        String productName = sc.next();
                        products.add(productName);
                        System.out.println("Đã thêm sản phẩm: " + productName + " vào danh sách");
                        break;
                    case 2:
                        // sửa sản phẩm
                        if (products.isEmpty()) {
                            System.out.println("Sản phẩm trống rỗng!");
                        } else {
                            System.out.println("Danh sách sản phẩm: ");
                            for (int i = 0; i < products.size(); i++) {
                                System.out.println(i + 1 + ". " + products.get(i));
                            }
                        }
                        System.out.println("Nhập số thứ tự sẩn phẩm cần sửa: ");
                        int indexToEdit = sc.nextInt() - 1;
                        sc.nextLine(); // thêm dòng này để xuống dòng khi nhập các dữ liệu
                        if (indexToEdit >= 0 && indexToEdit < products.size()) {
                            System.out.println("Nhập tên sản phẩm mới: ");
                            String editedProductName = sc.nextLine();
                            products.set(indexToEdit, editedProductName);
                            System.out.println("Đã sửa vị trí sản phẩm " + (indexToEdit + 1) + " thành " + editedProductName);

                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }
                        break;
                    case 3:
                        // xóa sản phẩm
                        if (products.isEmpty()) {
                            System.out.println("Sản phẩm trống rỗng!");
                        } else {
                            System.out.println("Danh sách sản phẩm: ");
                            for (int i = 0; i < products.size(); i++) {
                                System.out.println(i + 1 + ". " + products.get(i));
                            }
                        }
                        System.out.println("Nhập số thứ tự sản phẩm cần xóa");
                        int indexToDetele = sc.nextInt() - 1;
                        sc.nextLine();
                        if (indexToDetele >= 0 && indexToDetele < products.size()) {
                            String xoaProductName = products.remove(indexToDetele);
                            System.out.println("Đã xóa sản phẩm: " + xoaProductName);
                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }

                        break;
                    case 4:
                        // hiển thị sản phẩm
                        if (products.isEmpty()) {
                            System.out.println("Sản phẩm trống rỗng!");
                        } else {
                            System.out.println("Danh sách sản phẩm: ");
                            for (int i = 0; i < products.size(); i++) {
                                System.out.println(i + 1 + ". " + products.get(i));
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Đang thoát chương trình...");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số từ 1 đến 5.");
                        break;
                }
            } catch (Exception e) {

                System.out.println("Lỗi: Vui lòng nhập số!");
                sc.nextLine(); // thêm dòng này để được vô hạn
            }
        }
    }
}
