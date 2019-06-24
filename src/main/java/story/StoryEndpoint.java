package story;

import https.www_howtodoinjava_com.xml.school.StudentDetailsResponse;
import org.abs.webservices.GetStories;
import org.abs.webservices.StoriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StoryEndpoint
{
    private static final String NAMESPACE_URI = "abs.org/webservices";

    private StoryRepository StoryRepository;

    @Autowired
    public StoryEndpoint(StoryRepository StoryRepository) {
        this.StoryRepository = StoryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStories")
    @ResponsePayload
    public StoriesResponse getStory(@RequestPayload GetStories request) {
        StoriesResponse response = new StoriesResponse();
        response.setStory(StoryRepository.findStudent(request.getId()));

        return response;
    }
}