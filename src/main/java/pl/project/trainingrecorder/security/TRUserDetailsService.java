//package pl.project.trainingrecorder.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import pl.project.trainingrecorder.domain.User;
//import pl.project.trainingrecorder.repository.UserRepository;
//
//import java.util.Optional;
//
//@Service
//public class TRUserDetailsService implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUserName(username);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
//
//        return user.map(TRUserDetails::new).get();
//    }
//}
