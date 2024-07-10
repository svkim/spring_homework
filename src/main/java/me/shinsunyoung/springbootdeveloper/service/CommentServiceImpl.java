//package me.shinsunyoung.springbootdeveloper.service;
//
//import lombok.RequiredArgsConstructor;
//import me.shinsunyoung.springbootdeveloper.domain.Board;
//import me.shinsunyoung.springbootdeveloper.domain.Comment;
//import me.shinsunyoung.springbootdeveloper.domain.Register;
//import me.shinsunyoung.springbootdeveloper.domain.User;
//import me.shinsunyoung.springbootdeveloper.repository.BoardRepository;
//import me.shinsunyoung.springbootdeveloper.repository.CommentRepository;
//import me.shinsunyoung.springbootdeveloper.repository.RegisterRepository;
//import me.shinsunyoung.springbootdeveloper.repository.UserRepository;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class CommentServiceImpl implements CommentService{
//
//    private final UserRepository userRepository;
//    private final RegisterRepository registerRepository;
//    private final CommentRepository commentRepository;
//
//    @Override
//    public Long writeComment(CommentRequestDTO commentRequestDTO, Long boardId, String email) {
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("이메일이 존재하지 않습니다."));
//        Register register = registerRepository.findByProductId(produrctId).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));
//        Comment result = Comment.builder()
//                .content(commentRequestDTO.getContent())
//                .board(board)
//                .member(member)
//                .build();
//        commentRepository.save(result);
//
//        return result.getId();
//    }
//
//    @Override
//    public List<CommentResponseDTO> commentList(Long id) {
//        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));
//        List<Comment> comments = commentRepository.findByBoard(board);
//
//        return comments.stream()
//                .map(comment -> CommentResponseDTO.builder()
//                        .comment(comment)
//                        .build())
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void updateComment(CommentRequestDTO commentRequestDTO, Long commentId) {
//        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
//        comment.update(commentRequestDTO.getContent());
//        commentRepository.save(comment);
//    }
//
//    @Override
//    public void deleteComment(Long commentId) {
//        commentRepository.deleteById(commentId);
//    }
//}