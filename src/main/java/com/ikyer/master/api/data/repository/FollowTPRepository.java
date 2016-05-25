package com.ikyer.master.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.FollowKey;
import com.ikyer.master.api.data.domain.FollowTP;

@Repository
public interface FollowTPRepository extends JpaRepository<FollowTP, FollowKey> {

}
