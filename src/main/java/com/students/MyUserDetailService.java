package com.students;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.students.db.entities.Users;
import com.students.db.repository.UsersRepository;

@Component
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = usersRepository.findByUserName(username);

		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException("User Not Found");
		}

		return new UserPrimcipal(user);
	}

}
