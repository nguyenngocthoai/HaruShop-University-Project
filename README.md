# Website bán hàng trực tuyến (HaruShop-University-Project)
Bài tập lớn Lập trình World Wide Web.
- Author: Nguyễn Ngọc Thoại
## Đề tài
SV hãy xây dựng 1 trong các ứng dụng web sau: (sử dụng kiến thức HTML, CSS, jQuery,Spring, …)

- Website bao gồm 3 loại người dùng tương tác: người dùng không có tài khoản (guest), người dùng có tài khoản (customer), người quản trị hệ thống (admin).
-  Người dùng không có tài khoản (guest) có các chức năng:
  1. Có thể đăng ký tài khoản của website với các thông tin cần thiết (email không trùng với tài khoản khác), sau khi đăng ký thành công với thông tin hợp lệ, lưu trữ CSDL + gửi email và thông báo về tài khoản.
  2. Xem danh sách sản phẩm (thiết bị máy tính, mỹ phẩm, quần áo ... tùy theo đề tài, danh sách
này lấy từ CSDL.
  3. Xem chi tiết của từng sản phẩm từ danh sách sản phẩm.
  4. Chọn mua từng sản phẩm (có thể chọn mua từ trang Web danh sách sản phẩm hay từ trang Web chi tiết của từng sản phẩm), sản phẩm sau khi chọn mua sẽ được đưa vào trong giỏ hàng, nếu chọn sản phẩm đã có trong giỏ hàng, cập nhật số lượng.
  5. Xem giỏ hàng (danh sách sản phẩm đã chọn mua, thông tin này lưu trong biến Session,
không cần cập nhật CSDL).
6. Khi xem giỏ hàng, có thể chỉnh sửa số lượng của từng sản phẩm trong giỏ hàng (nếu chỉnh
sửa số lượng là 0 -> bỏ sản phẩm đó ra khỏi giỏ hàng)
- Người dùng có tài khoản (customer) có thể thực hiện các chức năng của Người dùng không có tài
khoản (guest), ngoài ra người dùng có tài khoản (customer) còn có thể:
1. Xử lý thanh toán (chức năng này thực hiện khi giỏ hàng đã có sản phẩm và người dùng
đăng nhập thành công vào hệ thống): cập nhật thông tin vào CSDL , gửi email và thông
báo đăng ký đặt hàng thành công với các thông tin kèm theo. Sau khi xử lý thành công,
Session được xóa về null.
- Người quản trị hệ thống (admin) có thể thực hiện được chức năng như một người dùng có tài
khoản (customer). Ngoài ra, chức năng khác dành cho người quản trị hệ thống (admin) - Phần
Back-End:
1. Tìm kiếm thông tin về sản phẩm/loại sản phẩm, các đơn đặt sản phẩm.
2. Quản lý thông tin sản phẩm/loại sản phẩm:

  a. Xem danh sách sản phẩm/loại sản phẩm. 
  
  b. Xem chi tiết từng sản phẩm/loại sản phẩm.
  
  c.Xóa sản phẩm/loại sản phẩm trong trường hợp sản phẩm chưa có trong đơn hàng nào hoặc loại sản phẩm chưa có sản phẩm nào.
  
  d. Thêm mới, cập nhật thông tin sản phẩm/loại sản phẩm.
3. Quản lý thông tin đơn hàng trực tuyến:

  a. Xem danh sách các đơn hàng (sắp xếp theo ngày mua).
  
  b. Xem chi tiết đơn hàng.
  
  c. Cập nhật số lượng của mặt hàng trong đơn hàng trực tuyến.
  
  - Lưu ý cho các chức năng quản lý thông tin:
1. Ràng buộc khi xóa dữ liệu (tiêu chí ràng buộc SV cần định nghĩa phù hợp).
2. Trường hợp thêm hay cập nhật dữ liệu có thể kiểm tra phía Client bằng JavaScript/jQuery hoặc kiểm tra bằng Model phía Server, không dùng Functions/Check constraints/Stored
Procedures trong hệ quản trị CSDL nếu dùng ORM.

