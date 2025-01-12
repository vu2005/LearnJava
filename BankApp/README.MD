* Kiến thức khi làm dự án
    - Xác định rõ các đối tượng cần thực hiện trong dự án một cách tối ưu nhất
    - Với dự án quản lý tài khoản ngân hàng của tôi thì cần dùng những thứ đối tượng sau

    1. Danh sách tài khoản:
        - Lưu thông tin các tài khoản với khả năng tra cứu nhanh qua accountNumber.
        - Mỗi tài khoản bao gồm:
            - accountNumber (String): Số tài khoản.
            - owner (String): Tên chủ tài khoản.
            - alance (double): Số dư.
        - Sử dụng (HashMap) để quản lý danh sách tài khoản.
            - sử dụng containsKey để kiểm tra người dùng có tồn tại hay không!


        // Kiểm tra xem key "001" có tồn tại không
        if (students.containsKey("001")) {
            System.out.println("Key '001' tồn tại!");
        } else {
            System.out.println("Key '001' không tồn tại!");
        }

        // Kiểm tra key không tồn tại
        if (students.containsKey("003")) {
            System.out.println("Key '003' tồn tại!");
        } else {
            System.out.println("Key '003' không tồn tại!");
        }

2. Danh sách giao dịch:
   - Lưu lịch sử các giao dịch.
   - Mỗi giao dịch bao gồm:
   - transactionId (String): Mã giao dịch.
   - accountNumber (String): Số tài khoản liên quan.
   - amount (double): Số tiền giao dịch (dương là gửi, âm là rút).
   - date (LocalDateTime): Ngày giao dịch.
   - Sử dụng (ArrayList) để lưu danh sách giao dịch.
    3. Danh sách tài khoản bị khóa:
        - Lưu danh sách số tài khoản bị khóa (blacklist).
        - Sử dụng (HashSet) để kiểm tra nhanh xem một tài khoản có bị khóa hay không.
    4. Tài khoản ưu tiên:
        - Danh sách tài khoản sắp xếp theo số dư giảm dần.
        - Sử dụng (PriorityQueue).
    5. Tài khoản sắp xếp tự nhiên:
        - Lưu số tài khoản theo thứ tự tăng dần.
        - Sử dụng (TreeSet).

2. Sau khi xác định những thứ cần thực hiện trong dự án tiếp theo tạo models
    - tạo getter and setter
    - tạo constructor
    - tạo toString()

* So sánh khi nào dùng Public static And Private

1. Public static:
    - Phạm vi truy cập: Có thể truy cập bất kỳ đâu thông qua class.
    - Liên kết với: Thuộc về lớp dùng chung giữa các đối tượng.
    - Cách truy cập: Truy cập trực tiếp bằng cách dùng <ClassName>.variable.
    - Bộ nhớ (Instance vs Static): all đối tượng dùng chung một bản sao.
    - Tính đóng gói (Encapsulation): Thấp hơn (dễ bị truy cập hoặc thay đổi trực tiếp.)
2. Private:
    - Phạm vi truy cập: Chỉ trong lớp khai báo
    - Liên kết với Thuộc về từng đối tượng riêng lẻ.
    - Cách truy cập: Thông qua getter/setter nếu cần.
    - Bộ nhớ (instace vs static): Mỗi đối tượng có một bản sao riêng.
    - Tính đóng gói(Encapsulation): Cao(ẩn dữ liệu tốt hơn).

- Với dự án Quản lý ngân hàng cần bảo mật nên dùng Private
