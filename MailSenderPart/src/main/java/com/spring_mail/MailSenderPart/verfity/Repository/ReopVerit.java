package com.spring_mail.MailSenderPart.verfity.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_mail.MailSenderPart.verfity.VerfityItem;
@Repository
public interface ReopVerit extends JpaRepository<VerfityItem,Long> {
         VerfityItem findByEmail( String email);
}
