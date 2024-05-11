package az.ingress.bankapp.auth;



import az.ingress.bankapp.entity.User;
import az.ingress.bankapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {



   private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("begin");
       User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
log.info("end");
        System.out.println("user="+user);
        return user;
    }
}
