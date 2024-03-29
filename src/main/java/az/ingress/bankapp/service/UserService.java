package az.ingress.bankapp.service;


import az.ingress.bankapp.dto.UserDto;
import az.ingress.bankapp.entity.User;

public interface UserService {

    User getUser(Long id);
}
