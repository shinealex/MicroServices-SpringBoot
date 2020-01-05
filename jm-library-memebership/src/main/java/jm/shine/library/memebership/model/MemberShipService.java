package jm.shine.library.memebership.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemberShipService {
	
	private List<Member> members = new ArrayList<>(Arrays.asList(
			new Member(11, "Shine", "111/Edinburgn EHXX 0012"),
			new Member(12, "Alex", "112/Edinburgn EHXX 0012"),
			new Member(13, "Tom", "113/London SW1V 1JU")
			));
	
	public List<Member> getAllMembers() {
		return members;
	}
	
	public Member getMember(int id) {
		return members.stream().filter(t -> t.getId() == id).findFirst().get();
	}
	
	public void addMember(Member member) {
		members.add(member);
	}

	public void removeMember(int id) {
		members.removeIf(t -> t.getId() == id);
	}
	
}
