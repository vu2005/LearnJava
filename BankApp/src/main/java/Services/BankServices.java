package Services;

import Models.Account;
import Models.Transaction;

import java.util.*;

public class BankServices {
    public void addAccount(Map<String, Account> accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Nhập thông tin tài khoản---");
        try {
            System.out.print("Nhập số tài khoản: ");
            String accountNumber = sc.nextLine();
            if (accounts.containsKey(accountNumber)) {
                System.out.println("Tài khoản đã tồn tại!");
                return;
            }
            System.out.print("Nhập tên tài khoản: ");
            String owner = sc.nextLine();
            System.out.print("Nhập số dư ban đầu: ");
            double balance = sc.nextDouble();

            // Create a new account and add it to the map
            Account account = new Account(accountNumber, owner, balance);
            accounts.put(accountNumber, account); // Use `put` to insert into the map
            System.out.println("Tạo tài khoản thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            sc.nextLine(); // Clear input buffer
        }
    }

    public void performTransaction(Map<String, Account> accounts, List<Transaction> transactions) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Thực hiện giao dịch---");
        try {
            System.out.print("Nhập số tài khoản: ");
            String accountNumber = sc.nextLine();

            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Tài khoản không tồn tại!");
                return;
            }

            System.out.print("Nhập số tiền giao dịch (dương: gửi, âm: rút): ");
            double amount = sc.nextDouble();

            Account account = accounts.get(accountNumber);
            if (account.getBalance() + amount < 0) {
                System.out.println("Giao dịch thất bại: Số dư không đủ!");
                return;
            }

            // Update account balance
            account.setBalance(account.getBalance() + amount);
            Transaction transaction = new Transaction(
                    UUID.randomUUID().toString(),
                    accountNumber,
                    amount,
                    java.time.LocalDate.now()
            );
            transactions.add(transaction);

            System.out.println("Giao dịch thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            sc.nextLine(); // Clear input buffer
        }
    }

    public void deteleAccount(Map<String, Account> accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Xóa tài khoản---");
        try {
            if (accounts.isEmpty()) {
                System.out.println("Danh sách tài khoản trống rỗng !");

            } else {
                System.out.println("---Danh sách tài khoản---");
                System.out.printf("%-5s %-20s %-20s %-15s%n", "STT", "Số Tài Khoản", "Tên Chủ Tài Khoản", "Số Dư (VND)");
                System.out.println("-------------------------------------------------------------");
                int index = 1;
                for (Map.Entry<String, Account> entry : accounts.entrySet()) {
                    Account account = entry.getValue();
                    System.out.printf("%-5d %-20s %-20s %-15.2f%n",
                            index++, account.getAccountNumber(), account.getOwner(), account.getBalance());
                }
                System.out.println("Nhập số tài khoản cần xóa: ");
                String accountNumber = sc.nextLine();
                if (accounts.remove(accountNumber) != null) {
                    System.out.println("Xóa tài khoản thành công !");
                } else {
                    System.out.println("Tài khoản không tồn tại!");
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            sc.nextLine(); // Clear input buffer
        }
    }

    public void showAccount(Map<String, Account> accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Danh sách tài khoản---");
        try {
            if (accounts.isEmpty()) {
                System.out.println("Danh sách không có tài khoản!");
            } else {
                System.out.printf("%-5s %-20s %-20s %-15s%n", "STT", "Số Tài Khoản", "Tên Chủ Tài Khoản", "Số Dư (VND)");
                System.out.println("-------------------------------------------------------------");
                int index = 1;
                for (Map.Entry<String, Account> entry : accounts.entrySet()) {
                    Account account = entry.getValue();
                    System.out.printf("%-5d %-20s %-20s %-15.2f%n",
                            index++, account.getAccountNumber(), account.getOwner(), account.getBalance());
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            sc.nextLine(); // Clear input buffer
        }
    }

    public void showTransactions(List<Transaction> transactions) {
        System.out.println("---Lịch sử giao dịch---");
        try {
            if (transactions.isEmpty()) {
                System.out.println("Không có giao dịch nào!");
            } else {
                System.out.printf("%-5s %-20s %-15s %-15s %-15s%n", "STT", "Mã Giao Dịch", "Số Tài Khoản", "Số Tiền (VND)", "Ngày Giao Dịch");
                System.out.println("----------------------------------------------------------------------");
                int index = 1;
                for (Transaction transaction : transactions) {
                    System.out.printf("%-5d %-20s %-15s %-15.2f %-15s%n",
                            index++, transaction.getTransactionID(), transaction.getAccountNumber(),
                            transaction.getAmount(), transaction.getTransactionDate());
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    public void accountListBlock(Map<String, Account> accounts, Set<String> blacklistAccounts) {
        if (blacklistAccounts.isEmpty()) {
            System.out.println("Không có tài khoản nào bị khóa!");
        }else {
            System.out.println("Danh sách tài khoản bị khóa !");
            System.out.printf("%-5s %-20s %-20s %-15s%n", "STT", "Số Tài Khoản", "Tên Chủ Tài Khoản", "Số Dư (VND)");
            System.out.println("-------------------------------------------------------------");

            int index = 1;
            for (String accountNumber : blacklistAccounts) {
                Account account = accounts.get(accountNumber);
                if (account != null) {
                    System.out.printf("%-5d %-20s %-20s %-15.2f%n",
                            index++, account.getAccountNumber(), account.getOwner(), account.getBalance());
                } else {
                    System.out.println("Tài khoản đã bị xóa hoặc không tồn tại: " + accountNumber);
                }
            }
        }

    }
    public  void accountBlock (Map<String, Account> accounts, Set<String> blacklistAccounts) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%-5s %-20s %-20s %-15s%n", "STT", "Số Tài Khoản", "Tên Chủ Tài Khoản", "Số Dư (VND)");
        System.out.println("-------------------------------------------------------------");
        int index = 1;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            Account account = entry.getValue();
            System.out.printf("%-5d %-20s %-20s %-15.2f%n",
                    index++, account.getAccountNumber(), account.getOwner(), account.getBalance());
        }
        System.out.println("Nhập số tài khoản cần khóa: ");
        String accountNumber = sc.nextLine();
        if (accounts.containsKey(accountNumber)) {
            if (blacklistAccounts.contains(accountNumber)) {
                System.out.println("Tài khoản này đã bị khóa.");
            }else {
                blacklistAccounts.add(accountNumber);
                System.out.println("Tài khoản này đã khóa thành công !");
            }
        }else  {
            System.out.println("Không tìm thấy tài khoản này nằm trong danh sách! ");
        }
    }
    public void accountSearch(Map<String, Account> accounts) {
        System.out.print("Nhập số tài khoản hoặc tên chủ tài khoản cần tìm: ");
        Scanner sc = new Scanner(System.in);
        String searchTerm = sc.nextLine().toLowerCase();

        boolean found = false;
        // Tiêu đề bảng chỉ hiển thị khi có kết quả
        System.out.printf("%-5s %-20s %-20s %-15s%n", "STT", "Số Tài Khoản", "Tên Chủ Tài Khoản", "Số Dư (VND)");
        System.out.println("-------------------------------------------------------------");

        int index = 1;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            Account account = entry.getValue();
            if (account.getAccountNumber().equalsIgnoreCase(searchTerm) ||
                    account.getOwner().toLowerCase().contains(searchTerm)) {
                System.out.printf("%-5d %-20s %-20s %-15.2f%n",
                        index++, account.getAccountNumber(), account.getOwner(), account.getBalance());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy tài khoản phù hợp.");
        }
    }

}
