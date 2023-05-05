package com.adel.cqrseventsourcing.service;

import com.adel.cqrseventsourcing.model.Address;
import com.adel.cqrseventsourcing.model.Contact;
import com.adel.cqrseventsourcing.model.User;
import com.adel.cqrseventsourcing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(final String userId,
                           final String firstName,
                           final String lastName){
        final User user = User.builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        userRepository.save(user);
    }

    public void updateUser(final String userId,
                           final Set<Contact> contacts,
                           final Set<Address> addresses){
        final User user = userRepository.findById(userId);
        user.setContacts(contacts);
        user.setAddresses(addresses);
        userRepository.save(user);
    }

}
