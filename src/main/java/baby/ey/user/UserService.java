package baby.ey.user;


import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public UsersTbl create(String nickname, String email, String password, Integer relation) {
        UsersTbl user = new UsersTbl();
        user.setNickname(nickname);
        user.setEmail(email);
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //user.setPassword(passwordEncoder.encode(password));
        user.setPassword(password);
        user.setRelation(relation);
        this.userRepository.save(user);
        return user;
    }
}