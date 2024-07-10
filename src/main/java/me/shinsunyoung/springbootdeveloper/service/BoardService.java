package me.shinsunyoung.springbootdeveloper.service;

import me.shinsunyoung.springbootdeveloper.domain.Board;
import me.shinsunyoung.springbootdeveloper.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //게시글 작성
    public void write(Board board) {

        boardRepository.save(board);

    }

    //게시글 리스트
    //List<Board>값이 페이징 설정 해주면서 page<board>로 넘김
    public Page<Board> boardList(Pageable pageable) {


        return boardRepository.findAll(pageable);

    }

    //게시글 검색
    public Page<Board> boardSearchList(String searchKeyword, Pageable pageable) {

        return boardRepository.findByboardTitleContaining(searchKeyword, pageable);
    }

    //게시글 보기
    public Board boardView(Long boardId) {

        return boardRepository.findById(boardId).get();
//                .orElseThrow(() -> new RuntimeException("업는 id 입니다."));

    }

    //글 삭제
    public void boardDelete(Long boardId) {

        boardRepository.deleteById(boardId);
    }




}
