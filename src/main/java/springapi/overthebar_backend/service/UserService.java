package springapi.overthebar_backend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springapi.overthebar_backend.model.User;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();
//int age, String email, int id, String level, String name, int progression
        User user = new User(22, "nick@gmail.com", 1, "Beginner", "Nicholas Norsek", 4);

        userList.addAll(Arrays.asList(user));
    }


    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList){
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
        } 
    }
    return optional;
}
}
