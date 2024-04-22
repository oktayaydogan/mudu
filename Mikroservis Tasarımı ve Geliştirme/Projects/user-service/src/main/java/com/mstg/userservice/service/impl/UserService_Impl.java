package com.mstg.userservice.service.impl;

import com.mstg.userservice.dto.LoginDto;
import com.mstg.userservice.model.Users;
import com.mstg.userservice.repository.UserRepository;
import com.mstg.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService_Impl implements UserService {
    private final UserRepository _userRepository;

    @Override
    public boolean register() {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean login(LoginDto dto) {
        try {
            Optional<Users> optUser = _userRepository.findByUsername(dto.getUsername());

            if (optUser.isEmpty()){
                throw new Exception("User not found");
            }

            Users user = optUser.get();
            if (user.getPassword().equals(dto.getPassword())) {
                return true;
                /**
                 * login işlemi olacak
                 */

            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
