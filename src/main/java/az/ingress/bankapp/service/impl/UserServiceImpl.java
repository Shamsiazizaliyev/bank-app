package az.ingress.bankapp.service.impl;


import az.ingress.bankapp.dto.UserDto;
import az.ingress.bankapp.entity.User;
import az.ingress.bankapp.repository.UserRepository;
import az.ingress.bankapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User  getUser(Long id) {

        User user = null;
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        return user;
    }
}
