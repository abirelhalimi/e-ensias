package com.project.projet_jee.reporsitories;

import com.project.projet_jee.models.Account;
import com.project.projet_jee.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {


    List<Question> findAllByAccount(Account account);
    List<Question> findAllById(Long id);
}
