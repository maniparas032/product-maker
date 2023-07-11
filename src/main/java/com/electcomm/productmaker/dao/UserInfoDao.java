package com.electcomm.productmaker.dao;

import com.electcomm.productmaker.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoDao extends JpaRepository<UserInfo,Integer> {
    public Optional<UserInfo> findByEmail(String email);
}
