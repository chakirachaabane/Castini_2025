package tn.esprit.castini.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "influencer_collaborations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfluencerCollaboration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    @JsonBackReference
    private Campaign campaign;

    @Column(nullable = false, length = 255)
    private String influencerName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private SocialMediaPlatform socialPlatform;

    private int followersCount;

    @Column(precision = 5, scale = 2)
    private BigDecimal engagementRate; // %

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private CollaborationType collaborationType;

    @Column(precision = 10, scale = 2)
    private BigDecimal paymentAmount;

    private LocalDateTime createdAt;
}
