## Bài tập CRUD Job

**Tạo class Job và thêm thông tin**

```java
private ConcurrentHashMap<String, Job> jobs;

public JobController(){
        jobs=new ConcurrentHashMap<>();
        jobs.put("J-01",new Job("J-01","Lập trình viên BackEnd","Lập trình viên BackEnd những người đảm nhiệm công việc viết những đoạn code và chương trình để vận hành ứng dụng, website.",
        Location.HaNoi,15000000,100000000,"truong@hr.com"));
        jobs.put("J-02",new Job("J-02","Lập trình viên FrontEnd","Lập trình viên Front end (Front end developer) sẽ chịu trách nhiệm phát triển giao diện bên ngoài của một website dựa vào những bản thiết kế.",
        Location.DaNang,10000000,80000000,"nam@hr.com"));
        jobs.put("J-03",new Job("J-03","Lập trình viên FullStack","Lập trình viên Full-stack là người có thể làm các công việc liên quan tới databases, servers, systems engineering và client work.",
        Location.HaNoi,20000000,110000000,"son@hr.com"));
        jobs.put("J-04",new Job("J-04","Lập trình viên Java","Lập trình viên Java là người phát triển ứng dụng dựa trên ngôn ngữ Java.",
        Location.HoChiMinh,12000000,80000000,"truong@hr.com"));
        }
```  

**Sắp xếp danh sách job theo thành phố tuyển**

```java
@GetMapping(value = "/sortbylocation")
public List<Job> sortByLocation(){
        return jobs.values().stream().sorted(Comparator.comparing(Job::getLocation)).collect(Collectors.toList());
        }
```

![image](https://user-images.githubusercontent.com/95077178/168507484-dd06bd5d-f927-436a-9832-e02d543793a8.png)

**Tìm các job mà {salary} trong khoảng min_salary và max_salary**

```java
@GetMapping(value = "/salary/{salary}")
public List<Job> findJobBySalary(@PathVariable("salary") int salary){
        return jobs.values().stream().filter(o1->o1.getMax_salary()>=salary&&o1.getMin_salary()<=salary).collect(Collectors.toList());
        }
```

![image](https://user-images.githubusercontent.com/95077178/168507637-d95ac488-56bb-409e-b26d-364ec6fb4fdb.png)  
**Tìm các job mà title hoặc description chứa {keyword}**

```java
 @GetMapping(value = "/keyword/{keyword}")
public List<Job> findJobByKeyWord(@PathVariable("keyword") String keyword){
        return jobs.values()
        .stream()
        .filter(o1->o1.getTitle().toLowerCase().contains(keyword)
        ||o1.getDescription().toLowerCase().contains(keyword))
        .collect(Collectors.toList());
        }
```

![image](https://user-images.githubusercontent.com/95077178/168507735-5b8b413f-2e75-40e2-997c-c12aef6d22fc.png)

**Tìm các job mà title hoặc description chứa {keyword} đồng thời location ={location}**

```java
@GetMapping(value = "/query")
public List<Job> findJobByLocation(@RequestParam("keyword") String keyword,@RequestParam("location") Location location){
        return jobs.values()
        .stream()
        .filter(o1->(o1.getTitle().toLowerCase().contains(keyword)
        ||o1.getDescription().toLowerCase().contains(keyword))
        &&o1.getLocation()==location)
        .collect(Collectors.toList());
        }
```  

![image](https://user-images.githubusercontent.com/95077178/168507886-471ea4b2-ebf5-426a-a579-c0489acaa3b7.png)
