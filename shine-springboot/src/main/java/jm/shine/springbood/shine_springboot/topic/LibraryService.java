package jm.shine.springbood.shine_springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {
	
	private List<Library> topics =  new ArrayList<Library>(Arrays.asList(
			new Library("one", "Shine", "My Topics Shine"),
			new Library("two", "alex", "My Topics alex"),
			new Library("three", "limy", "My Topics limy")
			));
	
    public List<Library> getAllTopics() {
    	return topics;
    }

    public Library getTopic(String id) {
    	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

	public void addTopic(Library topic) {
		topics.add(topic);
	}

	public void updateTopic(Library topic, String id) {
		for(int i = 0; i < topics.size(); i ++) {
			Library temp = topics.get(i);
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
