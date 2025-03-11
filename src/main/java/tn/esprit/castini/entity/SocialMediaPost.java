package tn.esprit.castini.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "social_media_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialMediaPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    @JsonBackReference
    private Campaign campaign;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private SocialMediaPlatform platform;

    @Column(columnDefinition = "TEXT")
    private String postContent;

    @Column(length = 255)
    private String imageUrl;

    private LocalDateTime postDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private PostStatus status;

    private int likes;
    private int shares;
    private int comments;

    private LocalDateTime createdAt;
}
