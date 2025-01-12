package projects.javacore.services;

import projects.javacore.Main;
import projects.javacore.models.Order;
import projects.javacore.models.OrderDetail;
import projects.javacore.models.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderServices {
    public void order() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Mua Sản Phẩm-----");
        try {
            System.out.print("Mã Đặt Hàng: ");
            int id = sc.nextInt();
            sc.nextLine(); // Bỏ qua ký tự xuống dòng sau nextInt()

            System.out.print("Tên Khách Hàng: ");
            String customerName = sc.nextLine();

            System.out.print("Số Điện Thoại: ");
            String phone = sc.nextLine();

            System.out.print("Nhập Email: ");
            String email = sc.nextLine();

            Order order = new Order(id, customerName, phone, email);

            System.out.println("-----Danh sách sản phẩm-----");

            String header = String.format("%-10s %-20s %-10s %-10s %-20s",
                    "Mã", "Tên", "Giá", "Số Lượng", "Ghi Chú");
            System.out.println(header);
            for (Product p : Main.PRODUCTS) {
                String row = String.format("%-10s %-20s %-10.2f %-10d %-20s",
                        p.getId(),
                        p.getName(),
                        p.getPrice(),
                        p.getQuantity(),
                        p.getDescription());
                System.out.println(row);
            }
            int productFunction = 1; // Khởi tạo để vào vòng lặp
            while (productFunction == 1) {
                System.out.print("Nhập mã sản phẩm cần mua: ");
                int productId = sc.nextInt();

                System.out.print("Nhập số lượng sản phẩm: ");
                int quantity = sc.nextInt();

                Product product = null;
                for (Product p : Main.PRODUCTS) {
                    if (p.getId() == productId) {
                        product = p;
                        break;
                    }
                }

                if (product == null) {
                    System.out.println("Mã sản phẩm không tồn tại. Vui lòng thử lại.");
                } else {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setId(order.getOrderDetails().size() + 1); // STT tăng dần
                    orderDetail.setOrderId(order.getId());
                    orderDetail.setQuantity(quantity);
                    orderDetail.setProductId(productId);
                    orderDetail.setPrice(product.getPrice());

                    order.getOrderDetails().add(orderDetail);
                }

                System.out.print("Nhập 1 để tiếp tục thêm sản phẩm, 0 để kết thúc: ");
                productFunction = sc.nextInt();
            }

            Main.ORDERS.add(order);
            System.out.println("Đặt hàng thành công!");

        } catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập sai giá trị. Vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void show() {
        System.out.println("-----Danh Sách Đặt Hàng-----");

        String header = String.format("%-10s %-20s %-15s %-25s",
                "Mã ĐH", "Tên Khách Hàng", "SĐT", "Email");
        System.out.println(header);
        System.out.println("====================================================");

        for (Order order : Main.ORDERS) {
            String row = String.format("%-10s %-20s %-15s %-25s",
                    order.getId(),
                    order.getCustomerName(),
                    order.getPhone(),
                    order.getEmail());
            System.out.println(row);

            String orderDetailHeader = String.format("%-5s %-20s %-10s %-10s %-10s",
                    "STT", "Tên Sản Phẩm", "SL", "Giá", "Tổng Giá");
            System.out.println(orderDetailHeader);

            for (OrderDetail orderDetail : order.getOrderDetails()) {
                Product product = null;
                for (Product p : Main.PRODUCTS) {
                    if (p.getId() == orderDetail.getProductId()) {
                        product = p;
                        break;
                    }
                }
                if (product != null) {
                    String orderDetailRow = String.format("%-5s %-20s %-10s %-10s %-10s",
                            orderDetail.getId(),
                            product.getName(),
                            orderDetail.getQuantity(),
                            product.getPrice(),
                            product.getPrice() * orderDetail.getQuantity());
                    System.out.println(orderDetailRow);
                }
            }
            System.out.println("----------------------------------------------------");
        }
    }
}
