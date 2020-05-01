package com.project.projet_jee.reporsitories;

import com.project.projet_jee.models.Comment;
import com.project.projet_jee.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    int countCommentByQuestion(Question question);

    List<Comment> findAllByQuestion(Question question);
    void deleteById(Long id);

}
