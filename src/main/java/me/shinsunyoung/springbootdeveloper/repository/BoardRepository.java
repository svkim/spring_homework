package me.shinsunyoung.springbootdeveloper.repository;

import me.shinsunyoung.springbootdeveloper.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

                //findBy(컬럼명)Contiaing 컬럼에 포함된 데이터 검색
    Page<Board> findByboardTitleContaining(String searchKeyword, Pageable pageable);


    //    Optional<List<Board>> findAllByBoardId(Long BoardId);

}
