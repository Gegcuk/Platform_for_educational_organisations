package com.gegcuk.university_management.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gegcuk.university_management.model.User;
import com.gegcuk.university_management.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        User user = new User();
        user.setFullName("John Doe");
        List<User> userList = Arrays.asList(user);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userService.getAllUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getFullName());
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setUserId(1);
        user.setFullName("John Doe");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1);
        assertEquals("John Doe", result.getFullName());
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setFullName("John Doe");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.saveUser(user);
        assertEquals("John Doe", result.getFullName());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setFullName("John Doe");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.updateUser(user);
        assertEquals("John Doe", result.getFullName());
    }

    @Test
    public void testDeleteUser() {
        int userId = 1;

        doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }
}
