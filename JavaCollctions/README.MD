# Tổng kết Kiến thức Lập trình Java

## Mục lục
1. [Giới thiệu](#giới-thiệu)
2. [Kiến thức đã học](#kiến-thức-đã-học)
    - [Cấu trúc dữ liệu cơ bản](#cấu-trúc-dữ-liệu-cơ-bản)
    - [So sánh các cấu trúc dữ liệu](#so-sánh-các-cấu-trúc-dữ-liệu)
3. [Các phép toán trên cấu trúc dữ liệu](#các-phép-toán-trên-cấu-trúc-dữ-liệu)
4. [Kết luận](#kết-luận)

---

## Giới thiệu

Chương trình này tóm tắt các kiến thức cơ bản về các cấu trúc dữ liệu trong Java và so sánh hiệu năng giữa các loại cấu trúc dữ liệu phổ biến. Việc sử dụng đúng cấu trúc dữ liệu sẽ giúp tối ưu hóa hiệu suất chương trình và giải quyết các bài toán một cách hiệu quả hơn.

---

## Kiến thức đã học

### Cấu trúc dữ liệu cơ bản
Trong Java, các cấu trúc dữ liệu phổ biến được chia thành các nhóm như sau:

1. **List**:
    - `ArrayList`: Cấu trúc dữ liệu này hỗ trợ việc truy cập ngẫu nhiên nhanh chóng với thời gian O(1). Tuy nhiên, việc chèn hoặc xoá phần tử ở giữa danh sách mất thời gian O(n) do phải dịch chuyển các phần tử.
    - `LinkedList`: Khác với `ArrayList`, `LinkedList` sử dụng các node có liên kết với nhau. Chèn và xoá phần tử ở bất kỳ vị trí nào có thể thực hiện trong O(1), nhưng truy cập các phần tử yêu cầu phải duyệt qua danh sách, do đó mất thời gian O(n).

2. **Set**:
    - `HashSet`: Được triển khai dựa trên bảng băm. Việc tìm kiếm, thêm và xóa phần tử có thời gian O(1) trung bình.
    - `LinkedHashSet`: Giống như `HashSet`, nhưng bảo tồn thứ tự phần tử khi duyệt qua.
    - `TreeSet`: Dựa trên cây nhị phân tự cân bằng (Red-Black Tree), hỗ trợ truy cập phần tử theo thứ tự, với thời gian O(log n) cho việc thêm, xóa và tìm kiếm.

3. **Map**:
    - `HashMap`: Một bảng băm để lưu trữ các cặp key-value. Phép toán tìm kiếm, thêm, xóa có thể thực hiện trong O(1) trung bình.
    - `LinkedHashMap`: Tương tự như `HashMap`, nhưng bảo vệ thứ tự phần tử theo thứ tự thêm vào.
    - `TreeMap`: Cấu trúc dữ liệu này sử dụng cây nhị phân tự cân bằng (Red-Black Tree), giúp duy trì các phần tử theo thứ tự tự nhiên hoặc theo một Comparator cụ thể, với thời gian O(log n) cho các thao tác cơ bản.

4. **Queue**:
    - `PriorityQueue`: Duy trì thứ tự ưu tiên của các phần tử, với thời gian O(log n) cho các phép toán như thêm và loại bỏ phần tử.
    - `LinkedList-as-Queue`: Dùng `LinkedList` làm Queue. Các phép toán như thêm (offer) và loại bỏ (poll) có thời gian O(1).

---

### So sánh các cấu trúc dữ liệu
Các phép toán phổ biến đối với các cấu trúc dữ liệu được so sánh như sau:

1. **Thêm phần tử** (`offer` hoặc `add`):
    - `PriorityQueue`: O(log n) do phải duy trì thứ tự ưu tiên.
    - `LinkedList`: O(1) nếu thêm vào cuối danh sách.

2. **Loại bỏ phần tử** (`poll`):
    - `PriorityQueue`: O(log n) để lấy và loại bỏ phần tử có độ ưu tiên cao nhất.
    - `LinkedList`: O(1) vì đây là thao tác trên đầu hoặc cuối danh sách.

3. **Duyệt qua các phần tử** (`iterator`):
    - `PriorityQueue`: O(n) vì phải duyệt qua tất cả các phần tử.
    - `LinkedList`: O(n) vì cần phải duyệt qua các node trong danh sách.

---

## Các phép toán trên cấu trúc dữ liệu

1. **Thêm phần tử vào trong danh sách**:
    - `ArrayList`: Dễ dàng chèn vào cuối danh sách, nhưng việc chèn vào giữa hoặc đầu có thể tốn thời gian O(n).
    - `LinkedList`: Có thể thêm phần tử ở đầu, giữa hoặc cuối danh sách với thời gian O(1), nhưng truy cập các phần tử sẽ mất O(n).

2. **Tìm kiếm phần tử**:
    - `HashSet`, `HashMap`: Tìm kiếm phần tử rất nhanh chóng với thời gian O(1) trung bình.
    - `TreeSet`, `TreeMap`: Tìm kiếm phần tử mất O(log n) do phải duy trì thứ tự các phần tử.

---

## Kết luận

Việc chọn cấu trúc dữ liệu phù hợp sẽ giúp tối ưu hóa hiệu suất của chương trình, đặc biệt là trong các trường hợp cần xử lý với lượng dữ liệu lớn. Các cấu trúc dữ liệu như `HashMap`, `HashSet` có thể rất hiệu quả trong việc tìm kiếm và thêm dữ liệu, trong khi đó, `TreeMap` và `TreeSet` sẽ hữu ích khi yêu cầu phải duy trì thứ tự của các phần tử.

Việc nắm rõ đặc điểm và sự khác biệt giữa các cấu trúc dữ liệu này là rất quan trọng để phát triển phần mềm hiệu quả và tối ưu hóa hiệu suất.

---

*Lưu ý*: Đây chỉ là tổng kết kiến thức cơ bản, bạn có thể áp dụng các kỹ thuật này trong các bài toán thực tế của mình để hiểu rõ hơn về cách sử dụng chúng trong các tình huống cụ thể.
