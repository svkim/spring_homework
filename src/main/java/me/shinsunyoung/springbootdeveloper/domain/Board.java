package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

//@date =  @Getter, @Setter, @ToString, @EqualsAndHashCode와 @RequiredArgsConstructor 합쳐둠
@Entity
@Data
@Table(name = "board_tb")
public class Board   {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "board_id" )
    private int boardId;

    @Column (name = "board_title", length = 20)
    private String boardTitle;

    @Column (name = "board_content", length = 1000)
    private String boardContent;

    @CreationTimestamp
    @Column (name = "board_date")
    private Timestamp boardDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Reply> reply;


//    @Builder
//    public Board(String boardTitle, String boardContent) {
//        this.boardTitle = boardTitle;
//        this.boardContent = boardContent;
//
//    }


   public void  update(String boardTitle, String boardContent){
       this.boardTitle = boardTitle;
       this.boardContent = boardContent;
   }


}
