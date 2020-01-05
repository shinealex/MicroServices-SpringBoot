package jm.shine.library.memebership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jm.shine.library.memebership.model.Member;
import jm.shine.library.memebership.model.MemberShipService;

@RestController
@RequestMapping("/membership")
public class MemberShipController {
	
	@Autowired
	MemberShipService memberShipService;
	
	@RequestMapping(value="/getAllMembers")
	public List<Member> getAllMembers() {
		return memberShipService.getAllMembers();
	}
	
	@RequestMapping(value="/getMember/{id}")
	public Member getMember(@PathVariable int id) {
		return memberShipService.getMember(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addMember")
	public void addMember(@RequestBody Member member) {
		memberShipService.addMember(member);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/remove/{id}")
	public void removeMember(@PathVariable int id) {
		memberShipService.removeMember(id);
	}
}
