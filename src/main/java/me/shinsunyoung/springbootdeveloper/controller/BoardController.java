package me.shinsunyoung.springbootdeveloper.controller;


import me.shinsunyoung.springbootdeveloper.domain.Board;
import me.shinsunyoung.springbootdeveloper.domain.User;
import me.shinsunyoung.springbootdeveloper.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import me.shinsunyoung.springbootdeveloper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;


@Slf4j
@Controller
public class BoardController {



    @Autowired
    private BoardService boardService;


    @GetMapping("/board/write")  //localhost:8080/board/write
    public String boardWriteForm(Model model, Principal principal, @AuthenticationPrincipal
    User username) {
        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }

        return "board/boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board, Model model, Principal principal, @AuthenticationPrincipal
    User username) {
        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }


        boardService.write(board);


//        if(){
        model.addAttribute("message", "글 작성이 완료되었습니다.");
//        }else{

//            model.addAttribute("message", "다시 작성해주세요");
//        }
        model.addAttribute("sUrl","/board/list");

        log.info("체크");

        return "board/message";
    }



    //게시판 리스트 호출 메서드
    @GetMapping("/board/list")
    public String boardList(Model model,  Principal principal, @AuthenticationPrincipal User username, @PageableDefault(page = 0, size = 10, sort = "boardId",
            direction = Sort.Direction.DESC)
//                            내림차순 : Sort.Direction.DESC 오름차순 : Sort.Direction.ASC String 값 : Sort.Direction.fromString( String 문자열 )
    Pageable pageable,
                            String searchKeyword){


        model.addAttribute("username", username.getNickname());

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }



        // 기존 Page(Board> list = boardService.boardList(pageable);
        // 검색 했을대 안했을때 구분 위한 null
        Page<Board> list = null;

        if (searchKeyword == null) {
            //검색x 기존 동일하게 모든데이터 불러오기
            list = boardService.boardList(pageable);
        }else {
            //검색한 데이터만 불러오기
            list = boardService.boardSearchList(searchKeyword, pageable);
        }


        //+1 <-- pageable 은 0부터 시작 +1 추가 1페이지부터시작
        int firstPage = list.getPageable().getPageNumber() + 1;
        //현재 페이지에서 가장 앞 페이지 번호를 보여줄 변수
        //-1 <-- 값이 들어가는것을 막기위해 max 값 으로 두개 값을 넣고 더 큰 값을 넣어줌
        //.max =  현제 페이지에서 -4해줬을때 1보다 작은수가나오면 안되서 1혹은 현제 페이지 -4했을때 보다 큰값을 쓰기 위함
        int startPage = Math.max(firstPage - 4, 1);
        //현재 페이지에서 가장 뒤에 페이지 번호를 보여줄 변수
        //.min = 해당 번호가 넘어가버리면 안되기때문에 최소값을 구하는 방식
        //리스트 토탈 페이지를 받아 디비 입력 데이터 불러오기
        int lastPage = Math.min(firstPage + 5, list.getTotalPages());

        //페이지 리스트
        model.addAttribute("list", list);
        //첫페이지 호출
        model.addAttribute("firstPage", firstPage);
        //시작페이지 호출
        model.addAttribute("startPage", startPage);
        //마지막 페이지 호출
        model.addAttribute("lastPage", lastPage);

        return "board/boardlist";
    }


    //보드 뷰 메서드
    @GetMapping("/board/view")   //localhost:8080/board/view ?  boardId = 1
    public String boardView(Model model,Long boardId,  Principal principal, @AuthenticationPrincipal User username) {

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }

        model.addAttribute("board", boardService.boardView(boardId));

        return "board/boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Long boardId, Model model,  Principal principal, @AuthenticationPrincipal User username) {

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }

        boardService.boardDelete(boardId);

        model.addAttribute("message", "글 삭제 완료.");
        model.addAttribute("sUrl","/board/list");


        return "board/message";
//        return "redirect:/board/list";
    }




    @GetMapping("/board/modify/{boardId}")
    public String boardModify(@PathVariable("boardId") Long boardId, Model model,  Principal principal, @AuthenticationPrincipal User username) {

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }

        model.addAttribute("board", boardService.boardView(boardId));

        return "board/boardmodify";
    }


    @PostMapping("/board/update/{boardId}")
    public String boardUpdate(@PathVariable("boardId") Long boardId, Board board, Model model,  Principal principal, @AuthenticationPrincipal User username) {

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }

        Board boardTemp = boardService.boardView(boardId);

        boardTemp.setBoardTitle(board.getBoardTitle());
        boardTemp.setBoardContent(board.getBoardContent());
//        boardTemp.setBoardDate(board.getBoardDate());

        boardService.write(boardTemp);


        model.addAttribute("message", "글 수정이 완료되었습니다.");
        model.addAttribute("sUrl","/board/list");



        return "board/message";
    }





}
