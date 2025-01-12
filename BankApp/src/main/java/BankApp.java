import Models.Account;
import Models.Transaction;
import Services.BankServices;

import java.time.LocalDate;
import java.util.*;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankServices bankServices = new BankServices();
        Map<String, Account> accounts = new HashMap<>();
        List<Transaction> transactions = new ArrayList<>();
        Set<String> blacklistAccounts = new HashSet<>();
        // Thêm dữ liệu ảo
//        addMockData(accounts, transactions);
        while (true) {
            try {
                System.out.println("\n--- ỨNG DỤNG QUẢN LÝ TÀI KHOẢN NGÂN HÀNG ---");
                System.out.println("1. Thêm tài khoản");
                System.out.println("2. Xóa tài khoản");
                System.out.println("3. Thực hiện giao dịch");
                System.out.println("4. Xem danh sách tài khoản");
                System.out.println("5. Xem lịch sử giao dịch");
                System.out.println("6. Khóa tài khoản");
                System.out.println("7. Tìm kiếm tài khoản");
                System.out.println("8. Danh sách tài khoản bị khóa");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        bankServices.addAccount(accounts);
                        break;
                    case 2:
                        // Implement delete account functionality
                        bankServices.deteleAccount(accounts);
                        break;
                    case 3:
                        bankServices.performTransaction(accounts, transactions);
                        break;
                    case 4:
                        // Hiển thị danh sách tài khoản
                        bankServices.showAccount(accounts);
                        break;
                    case 5:
                        bankServices.showTransactions(transactions);
                        break;
                    case 6:
                        // Implement account lock functionality
                        bankServices.accountBlock(accounts, blacklistAccounts);
                        break;
                    case 7:
                        // Implement search account functionality
                        bankServices.accountSearch(accounts);
                        break;
                    case 8:
                        bankServices.accountListBlock(accounts, blacklistAccounts);
                        break;
                    case 0:
                        System.out.println("Đang thoát chương trình...");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số từ 0 đến 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                sc.nextLine(); // Clear invalid input
            }
        }
    }

//    private static void addMockData(Map<String, Account> accounts, List<Transaction> transactions) {
//        // Thêm tài khoản mẫu
//        accounts.put("1", new Account("999991162005", "Nguyễn Như Vũ", 5000000));
//        accounts.put("2", new Account("29999991162005", "Nguyễn Như A", 3000000));
//        accounts.put("3", new Account("111", "Nguyễn Như C", 7000000));
//        accounts.put("4", new Account("999", "Nguyễn Như D", 2500000));
//
//        // Thêm giao dịch mẫu
//        transactions.add(new Transaction("123", "999991162005", 1000000.00, LocalDate.of(2000, 10, 10)));
//        transactions.add(new Transaction("123", "29999991162005", -500000.00, LocalDate.now()));
//        transactions.add(new Transaction("123", "111", 2000000.00, LocalDate.now()));
//        transactions.add(new Transaction("123", "999", -1000000.00, LocalDate.now()));
//
//        System.out.println("Dữ liệu ảo đã được thêm thành công!");
//    }
}
