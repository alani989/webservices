package student;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import https.www_howtodoinjava_com.xml.school.Student;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {

        Student student = new Student();
        student.setName("Sajal");
        student.setStandard(5);
        student.setAddress("Pune");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Kajal");
        student.setStandard(5);
        student.setAddress("Chicago");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Lokesh");
        student.setStandard(6);
        student.setAddress("Delhi");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Sukesh");
        student.setStandard(7);
        student.setAddress("Noida");
        students.put(student.getName(), student);
    }

//    public void makeCall() {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://expone-backend.alanidev.now.sh/api/stories/latest";
//        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
//        System.out.println(result);
//        Assert.assertEquals(200, result.getStatusCodeValue());
//        Assert.assertEquals(true, result.getBody().contains("employeeList"));
//    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }
}