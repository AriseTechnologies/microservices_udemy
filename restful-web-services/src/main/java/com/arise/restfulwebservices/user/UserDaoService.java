package com.arise.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	static {
		users.add(new User(++userCount, "Umesh", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Nagesh", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Ajay", LocalDate.now().minusYears(24)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findUserById(Integer id) {
//		for(User user : users) {
//			if(id == user.getId()) {
//				return user;
//			}
//		}
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public void createUSer(User user) {
		user.setId(++userCount);
		users.add(user);
		System.out.println(users);
	}

	public void deleteUser(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		System.out.println(users);
	}
	
}
