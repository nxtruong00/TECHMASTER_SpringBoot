## Câu hỏi ôn tập  
**1.Trong quá trình tạo dự án Spring Boot chúng ta phải khai báo những tham số sau đây : groupID, artifactID. Ý nghĩa các tham số này là gì?**  
GroupID chỉ định ID của nhóm dự án. Nó là duy nhất trong một tổ chức VD **com.companyname.project-group**  
ArtifactID chỉ định ID của dự án **(artifact)**  

**2.Tại sao phải đảo ngược tên miền trong <groupId/>vn.techmaster</groupId/>?**  
  
**3.SpringBoot có 2 cơ chế để quản lý thư viện. Hãy kể tên chúng?**  

**4.File `pom.xml` có tác dụng gì?**  
File pom.xml là nơi khai báo tất cả những gì liên quan đến dự án được cấu hình qua maven, như khai báo các dependency, version của dự án, tên dự án, repossitory.  

**5.Trong file pom.xml có các thẻ dependency. Ý nghĩa của chúng là gì?**  
Trong Maven, **dependency là một kho lưu trữ khác** -JAR, WAR cái mà chúng ta cần để biên dịch, xây dựng, thử nghiệm hoặc chạy. Khi chúng ta chạy một bản dựng maven hoặc thực thi một mục tiêu maven, các dependency này sẽ được giải quyết và sau đó được tải từ **local repository.**  

**6.Ý nghĩa của @Controllerlà gì?**  
**Controller** là nơi tiếp nhận **request** và trả về **response** cho client.  
**@Controller** có thể trả về View qua một String hoặc JSON data trong response body (nếu được chỉ định). Thích hợp cho các controller có routing, chuyển trang.  

**7.Ý nghĩa của @RequestMapping là gì? Nó có những tham số gì ngoài value?**  
**@RequestMapping** dùng để ánh xạ một request tới một phương thức, có thể sử dụng @RequestMapping chú thích cho một phương thức hoặc một lớp. Một phương thức chú thích bởi annotation  @RequestMapping sẽ trở thành phương thức xử lý request và sẽ được gọi khi dispatcher servlet nhận được một request với URL phù hợp.  
