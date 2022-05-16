package vn.techmaster.myfirstweb.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.myfirstweb.model.Book;
import vn.techmaster.myfirstweb.model.Message;
import vn.techmaster.myfirstweb.model.Student;

@Controller
@RequestMapping("/")
public class HomeController {
private List<Student> list
    @GetMapping(value = "/random", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getRandomString() {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String alphaUpperCase = alpha.toUpperCase();
        String digits = "0123456789";
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        StringBuilder sb = new StringBuilder();
        Random randomNumber = new Random();

        for (int i = 0; i < 8; i++) {
            int number = randomNumber.nextInt(ALPHA_NUMERIC.length());
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return "Random String: "+sb;
    }

    @GetMapping(value = "/quote", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getRandomSentences() {
        String[] sentences = new String[]{"Kiến tha lâu đầy tổ",
                "Có công mài sắt có ngày nên kim",
                "Không thấy đố mày làm nên",
                "Học thầy không tày học bạn"};
        Random rd = new Random();
        int index = rd.nextInt(4);
        return "Câu tục ngữ ngẫu nhiên: "+sentences[index];
    }

    @GetMapping("/bmi")
    @ResponseBody
    public double calculateBMI(@RequestParam("weight") double weight, @RequestParam("height") double height) {
        double bmi = weight / Math.pow(height, 2);
        return Math.ceil(bmi * 100) / 100;
    }

    Student student1=new Student("HS001","Nam",16);
    Student student2=new Student("HS002","Trường",18);
    Student student3=new Student("HS003","Trung",17);

    @GetMapping("/student")
    @ResponseBody
    public int getAllStudents (@RequestParam("a") int a, @RequestParam("b") int b) {
        List<Student>list=new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

    }

    @GetMapping(value = "/hi", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String hello() {
        return "<h1>Hello World</h1><h3>Cool</h3>";
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book getBook() {
        return new Book("Dế Mèn Phiêu Luu Ky", "Tô Hoài", "1945");
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Book book_xml() {
        return new Book("x111", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài");
    }

    @GetMapping("/add/{a}/{b}")
    @ResponseBody
    public int add(@PathVariable("a") int aa, @PathVariable("b") int bb) {
        return aa + bb;
    }

    @GetMapping("/name/{your_name}")
    @ResponseBody
    public String hi(@PathVariable("your_name") String yourName) {
        return "Hi " + yourName;
    }

    @GetMapping("/year/{year}")
    @ResponseBody
    public int getAge(@PathVariable("year") int year) {
        return Calendar.getInstance().get(Calendar.YEAR) - year;
    }

    @GetMapping("/random/{length}")
    @ResponseBody
    public String randomString(@PathVariable("length") int length) {
        return "XXXmmmMmmWW";
    }

    @GetMapping("/add")
    @ResponseBody
    public int add2(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a + b;
    }

    @PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message echoMessage(@RequestBody Message message) {
        return message;
    }

}
