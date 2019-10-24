package com.zry.springbootTest.repository;

import com.zry.springbootTest.pojo.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {

    Visitor findAllByIp(String ip);
}
