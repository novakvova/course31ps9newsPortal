package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import entities.User;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private Session session; // This will auto-inject the authentication service into the controller.
	private static List<User> users = new ArrayList<User>();

	public CustomAuthenticationProvider(SessionFactory sessionFactory) {
		users.add(new User("erin", "123", "ROLE_ADMIN"));
		users.add(new User("mike", "234", "ROLE_ADMIN"));
		session = sessionFactory.openSession();
		System.out.println("------Connection good---Security--");
		//session.close();
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		Object credentials = authentication.getCredentials();
		System.out.println("credentials class: " + credentials.getClass());

		if (!(credentials instanceof String)) {
			return null;
		}
		String password = credentials.toString();

		Optional<User> userOptional = users.stream().filter(u -> u.match(name, password)).findFirst();

		if (!userOptional.isPresent()) {
			throw new BadCredentialsException("Authentication failed for " + name);
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(userOptional.get().getRole()));
		Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
		// return false;
	}

}
