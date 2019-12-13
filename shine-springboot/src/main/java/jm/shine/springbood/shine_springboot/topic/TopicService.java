package jm.shine.springbood.shine_springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics =  new ArrayList<Topic>(Arrays.asList(
			new Topic("one", "Shine", "My Topics Shine"),
			new Topic("two", "alex", "My Topics alex"),
			new Topic("three", "limy", "My Topics limy")
			));
	
    public List<Topic> getAllTopics() {
    	return topics;
    }

    public Topic getTopic(String id) {
    	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i = 0; i < topics.size(); i ++) {
			Topic temp = topics.get(i);
			if (temp.getId().equals(topic.getId())) {
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
