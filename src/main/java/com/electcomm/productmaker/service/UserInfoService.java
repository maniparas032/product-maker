package com.electcomm.productmaker.service;

import com.electcomm.productmaker.dao.UserInfoDao;
import com.electcomm.productmaker.model.UserInfo;
import com.electcomm.productmaker.model.UserInfoUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoDao.findByEmail(username);
//        UserInfo myUser  = userInfo.orElseThrow(()-> new UsernameNotFoundException("No such email found"));
        return userInfo.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("No such user found"));
    }

    public UserInfo addUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserInfo savedUser = userInfoDao.save(userInfo);
        return savedUser;
    }
}
