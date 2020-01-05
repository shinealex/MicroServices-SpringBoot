package jm.shine.library.activities.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ActivityService {
	
	private Map <String, List<Activity>> activities = new HashMap<>();
	
	public void issueBook(String memberId, String bookId) {
		
		List<Activity> activityList = activities.get(memberId);
		
		if (activityList == null || activityList.size() == 0) {
			
			activityList = new ArrayList<>();
			activityList.add(new Activity(memberId, bookId, ActivityType.ISSUE));
			activities.put(memberId, activityList);
			
		} else {
			
			activities.get(memberId).add(new Activity(memberId, bookId, ActivityType.ISSUE));
			
		}
	}

	public List<String> getListOfBooks(String memberId) {
		
		return activities.
				   entrySet()
				   .stream()
				   .map(Map.Entry :: getValue)
				   .flatMap(List :: stream)
				   .filter(t -> ! t.getActivityType().equals(ActivityType.RETURN))
				   .map(t -> t.getBookId())
				   .collect(Collectors.toList());
		   
	}

}
