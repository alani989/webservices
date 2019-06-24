package story;

import https.www_howtodoinjava_com.xml.school.Student;
import org.abs.webservices.Story;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StoryRepository {
    private static final Map<String, Story> stories = new HashMap<>();

    @PostConstruct
    public void initData() {
        makeCall();
    }

    public void makeCall() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://expone-backend.alanidev.now.sh/api/stories/latest";
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        System.out.println(result);
//        Assert.assertEquals(200, result.getStatusCodeValue());
//        Assert.assertEquals(true, result.getBody().contains("employeeList"));
    }

    public Story findStudent(String _id) {
        Assert.notNull(_id, "The story's id must not be null");
        return stories.get(_id);
    }
}