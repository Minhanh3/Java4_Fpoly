
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Favorites")
public class Favorites {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "VideoId")
    private String videoId;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "LikeDate")
    private Date likeDate;

}
