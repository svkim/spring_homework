package me.shinsunyoung.springbootdeveloper.repository;

import me.shinsunyoung.springbootdeveloper.domain.Board;
import me.shinsunyoung.springbootdeveloper.domain.Comment;
import me.shinsunyoung.springbootdeveloper.domain.Register;

import java.util.List;

public interface CommentRepository {

    List<Comment> findByRegister(Register register);
}
