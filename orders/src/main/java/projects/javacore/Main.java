package projects.javacore;

import projects.javacore.models.Order;
import projects.javacore.models.Product;
import projects.javacore.services.OrderServices;
import projects.javacore.services.ProductServices;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static List<Product> PRODUCTS = new ArrayList<Product>();
    public static List<Order> ORDERS = new ArrayList<Order>();

    public static void menu() {
        System.out.println("------Danh sách chức năng------");
        System.out.println("1. Thêm Mới Sản Phẩm");
        System.out.println("2. Sửa Sản Phẩm");
        System.out.println("3. Xóa Sản Phẩm");
        System.out.println("4. Tìm Kiếm");
        System.out.println("5. Tính Min Theo Giá");
        System.out.println("6. Tính Max Theo Giá");
        System.out.println("7. Hiển Thị Danh Sách Sản Phẩm");
        System.out.println("8. Mua Hàng");
        System.out.println("9. Danh Sách Mua Hàng");
        System.out.println("10. Thoát");

    }

    public static void main(String[] args) {
        int function = 0;
        do {
            menu();

            try {
                Scanner sc = new Scanner(System.in);

                System.out.print("Chọn chức năng: ");
                function = sc.nextInt();
                ProductServices productServices = new ProductServices();
                OrderServices orderServices = new OrderServices();
                switch (function) {
                    case 1:
                        productServices.insert();
                        break;
                    case 2:
                        productServices.update();
                        break;
                    case 3:
                        productServices.delete();
                        break;
                    case 4:
                        productServices.search();
                        break;
                    case 5:
                        productServices.min();
                        break;
                    case 6:
                        productServices.max();
                        break;
                    case 7:
                        productServices.show();
                        break;
                    case 8:
                        orderServices.order();
                        break;
                    case 9:
                        orderServices.show();
                        break;
                    default:
                        break;
                }

            } catch (InputMismatchException ei) {
                System.out.println("Bạn đã nhập sai giá trị vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (function != 10);
        System.out.print("Cảm ơn bạn đã sử dụng phần mềm");
    }
}