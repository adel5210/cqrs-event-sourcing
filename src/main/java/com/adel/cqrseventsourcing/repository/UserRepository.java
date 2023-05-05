package com.adel.cqrseventsourcing.repository;

import com.adel.cqrseventsourcing.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserRepository {

    private static final Map<String, User> store = new HashMap<>();

    public void save(final User user){
        store.put(user.getUserId(),
                user);
    }

    public List<User> findAll(){
        return new ArrayList<>(store.values());
    }

    public User findById(String id){
        return store.get(id);
    }
}
