package me.shinsunyoung.springbootdeveloper.repository;

import me.shinsunyoung.springbootdeveloper.domain.Register;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface RegisterRepository extends CrudRepository<Register, Long> {
    ArrayList<Register> findAll();

    List<Register> findByPrdMajorcategoryAndPrdSubcategory(String prdMajorcategory, String prdSubcategory);

    List<Register> findByPrdName(String prdName);

//댓글 조회
List<Register> findByProductId(Long productId);



}
