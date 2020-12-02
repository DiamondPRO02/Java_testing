package com.github.DiamondPRO02.validation;

import com.github.DiamondPRO02.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static org.codehaus.plexus.util.StringUtils.isBlank;

@Component
@RequiredArgsConstructor
public class UsernameValidation implements Predicate<String> {
    private final UserRepository userRepository;

    @Override
    public boolean test(String username) {
        boolean result = true;

        if(isBlank(username)){
            System.out.println("Username must contain at least 4 charachter");
            result = false;
        }
        if(userRepository.usernameExists(username)){
            System.out.println("Username already in use!");
            result = false;
        }
        return result;
    }
}
