package org.souayrioss.visionarycroftingspringmvc.service.Imp;


import org.souayrioss.visionarycroftingspringmvc.Repository.UserRepository;
import org.souayrioss.visionarycroftingspringmvc.entity.User;
import org.souayrioss.visionarycroftingspringmvc.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(String email)  {

            if (userRepository.existsByEmail(email)) {
                Optional<User> userConnect = userRepository.findByEmail(email);
                if (userConnect.isEmpty()) {
                    return null;
                }else {
                    return userConnect;
                }
            }else {
                return null;
            }
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Page getAll(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Object getOne(String ref) {
        return null;
    }
}
