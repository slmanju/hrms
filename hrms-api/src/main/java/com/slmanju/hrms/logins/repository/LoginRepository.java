package com.slmanju.hrms.logins.repository;

import com.slmanju.hrms.logins.service.entity.Login;
import com.slmanju.hrms.logins.service.transfer.dto.LoginSearchRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public interface LoginRepository extends JpaRepository<Login, Integer> {

  @Query("SELECT login FROM Login login")
  Page<Login> search(@Param("searchRequest") LoginSearchRequest searchRequest, Pageable pageable);

}
