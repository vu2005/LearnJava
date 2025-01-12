package projects.javacore.services;

import projects.javacore.Main;
import projects.javacore.models.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductServices {

    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----Nhập Thông Tin Sản Phẩm----");
        try {
            System.out.println("Mã: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.println("Tên Sản Phẩm: ");
            String name = sc.nextLine();

            System.out.println("Giá: ");
            Float price = sc.nextFloat();

            System.out.println("Số Lượng: ");
            int quantity = sc.nextInt();

            sc.nextLine();

            System.out.println("Ghi Chú: ");
            String description = sc.nextLine();

            Product p = new Product(id, name, price, quantity, description);
            Main.PRODUCTS.add(p);

        } catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập sai giá trị vui lòng nhập lại");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        try {
            // Hiển thị thông tin sản phẩm cũ
            System.out.println("-----Thông tin sản phẩm hiện tại-----");
            String header = String.format("%-10s %-20s %-10s %-10s %-20s", "Mã", "Tên", "Giá", "Số Lượng", "Ghi Chú");
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
            // Nhập mã sản phẩm cần cập nhật
            System.out.println("Nhập Mã sản phẩm cần cập nhật: ");
            int id = sc.nextInt();

            // Tìm sản phẩm theo id
            Product product = null;
            for (Product p : Main.PRODUCTS) {
                if (p.getId().equals(id)) {
                    product = p;
                    break;
                }
            }

            if (product == null) {
                System.out.println("Không tìm thấy sản phẩm với mã: " + id);
                return;
            }


            // Nhập thông tin mới
            sc.nextLine(); // Clear buffer
            System.out.println("Nhập tên mới (hoặc để trống nếu không thay đổi): ");
            String newName = sc.nextLine();
            if (!newName.isEmpty()) {
                product.setName(newName);
            }

            System.out.println("Nhập giá mới (hoặc để trống nếu không thay đổi): ");
            String newPriceInput = sc.nextLine();
            if (!newPriceInput.isEmpty()) {
                float newPrice = Float.parseFloat(newPriceInput);
                if (newPrice > 0) {
                    product.setPrice(newPrice);
                } else {
                    System.out.println("Giá phải lớn hơn 0!");
                }
            }

            System.out.println("Nhập số lượng mới (hoặc để trống nếu không thay đổi): ");
            String newQuantityInput = sc.nextLine();
            if (!newQuantityInput.isEmpty()) {
                int newQuantity = Integer.parseInt(newQuantityInput);
                if (newQuantity >= 0) {
                    product.setQuantity(newQuantity);
                } else {
                    System.out.println("Số lượng phải không âm!");
                }
            }

            System.out.println("Nhập ghi chú mới (hoặc để trống nếu không thay đổi): ");
            String newDescription = sc.nextLine();
            if (!newDescription.isEmpty()) {
                product.setDescription(newDescription);
            }

            System.out.println("Cập nhật sản phẩm thành công!");
            String showheader = String.format("%-10s %-20s %-10s %-10s %-20s",
                    "Mã", "Tên", "Giá", "Số Lượng", "Ghi Chú");
            System.out.println(showheader);
            for (Product p : Main.PRODUCTS) {
                String row = String.format("%-10s %-20s %-10.2f %-10d %-20s",
                        p.getId(),
                        p.getName(),
                        p.getPrice(),
                        p.getQuantity(),
                        p.getDescription());
                System.out.println(row);
            }
        } catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập sai giá trị. Vui lòng nhập lại!");
            sc.nextLine(); // Clear buffer
        } catch (NumberFormatException en) {
            System.out.println("Dữ liệu nhập vào không hợp lệ. Vui lòng thử lại!");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Thông tin sản phẩm hiện tại:");
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
            // Nhập mã sản phẩm cần cập nhật
            System.out.println("Nhập Mã sản phẩm cần xóa: ");
            int id = sc.nextInt();

            // Tìm sản phẩm theo id
            Product product = null;
            for (Product p : Main.PRODUCTS) {
                if (p.getId().equals(id)) {
                    product = p;

                    break;
                }
            }

            if (product == null) {
                System.out.println("Không tìm thấy sản phẩm với mã: " + id);
                return;
            }
            Main.PRODUCTS.remove(product);
            System.out.println("Đã xóa sản phẩm thành công");
            System.out.println("Danh sách sản phẩm sau khi xóa:");
            String showheader = String.format("%-10s %-20s %-10s %-10s %-20s",
                    "Mã", "Tên", "Giá", "Số Lượng", "Ghi Chú");
            System.out.println(showheader);
            for (Product p : Main.PRODUCTS) {
                String row = String.format("%-10s %-20s %-10.2f %-10d %-20s",
                        p.getId(),
                        p.getName(),
                        p.getPrice(),
                        p.getQuantity(),
                        p.getDescription());
                System.out.println(row);
            }
        } catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập sai giá trị. Vui lòng nhập lại!");
            sc.nextLine(); // Clear buffer
        } catch (NumberFormatException en) {
            System.out.println("Dữ liệu nhập vào không hợp lệ. Vui lòng thử lại!");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    public static void search() {
        Scanner sc = new Scanner(System.in);
        try {

            // Nhập mã sản phẩm cần cập nhật
            System.out.println("Nhập tên sản phẩm cần tìm: ");
            String name = sc.nextLine();

            // Tìm sản phẩm theo tên
            Product product = null;
            for (Product p : Main.PRODUCTS) {
                if (p.getName().equalsIgnoreCase(name)) {
                    product = p;
                    break;
                }
            }
            if (product == null) {
                System.out.println("Không tìm thấy sản phẩm với : " + name);
            } else {
                System.out.println("Danh sách sản phẩm sau khi tìm kiếm:");
                String showheader = String.format("%-10s %-20s %-10s %-10s %-20s",
                        "Mã", "Tên", "Giá", "Số Lượng", "Ghi Chú");
                System.out.println(showheader);
                String row = String.format("%-10s %-20s %-10.2f %-10d %-20s",
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getDescription());
                System.out.println(row);
            }

        } catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập sai giá trị. Vui lòng nhập lại!");
            sc.nextLine(); // Clear buffer
        } catch (NumberFormatException en) {
            System.out.println("Dữ liệu nhập vào không hợp lệ. Vui lòng thử lại!");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    public static void min() {
        try {
            // Kiểm tra danh sách có sản phẩm hay không
            if (Main.PRODUCTS.isEmpty()) {
                System.out.println("Danh sách sản phẩm rỗng!");
                return;
            }

            // Tìm sản phẩm có giá nhỏ nhất
            Product minProduct = Main.PRODUCTS.get(0);
            for (Product p : Main.PRODUCTS) {
                if (p.getPrice() < minProduct.getPrice()) {
                    minProduct = p;
                }
            }

            // Hiển thị sản phẩm có giá nhỏ nhất
            System.out.println("Sản phẩm có giá nhỏ nhất:");
            String showheader = String.format("%-10s %-20s %-10s %-10s %-20s",
                    "Mã", "Tên", "Giá", "Số Lượng", "Ghi Chú");
            System.out.println(showheader);

            String row = String.format("%-10s %-20s %-10.2f %-10d %-20s",
                    minProduct.getId(),
                    minProduct.getName(),
                    minProduct.getPrice(),
                    minProduct.getQuantity(),
                    minProduct.getDescription());
            System.out.println(row);

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }


    public void max() {
        try {
            if (Main.PRODUCTS.isEmpty()) {
                System.out.println("Danh sách sản phẩm rỗng!");
                return;
            }
            Product maxProduct = Main.PRODUCTS.get(0);
            for (Product p : Main.PRODUCTS) {
                if (p.getPrice() > maxProduct.getPrice()) {
                    maxProduct = p;
                }
            }
            System.out.println("Sản phẩm có giá nhỏ nhất:");
            String showheader = String.format("%-10s %-20s %-10s %-10s %-20s",
                    "Mã", "Tên", "Giá", "Số Lượng", "Ghi Chú");
            System.out.println(showheader);

            String row = String.format("%-10s %-20s %-10.2f %-10d %-20s",
                    maxProduct.getId(),
                    maxProduct.getName(),
                    maxProduct.getPrice(),
                    maxProduct.getQuantity(),
                    maxProduct.getDescription());
            System.out.println(row);
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    public void show() {
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
    }
}
