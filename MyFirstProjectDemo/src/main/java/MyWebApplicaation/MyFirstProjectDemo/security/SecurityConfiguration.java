package MyWebApplicaation.MyFirstProjectDemo.security;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    	
      UserDetails user1=	createUserName("in28minutes","dummy");
     UserDetails user2= createUserName("rte","rte");
    	return new InMemoryUserDetailsManager(user1,user2);
    }

	private UserDetails createUserName(String name,String password) {
		Function<String, String> encoder = input -> passwordEncoder().encode(input);
		
    	UserDetails user = User.builder().
    			passwordEncoder(
    			encoder
    			)
            .username(name)
            .password(password)
            .roles("USER","ADIM")
            .build();
        return user;
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
}