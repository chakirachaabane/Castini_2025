package tn.esprit.castini.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "marketing_targets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketingTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    @JsonBackReference
    private Campaign campaign;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private AudienceType audienceType;


    @Column(columnDefinition = "TEXT")
    private String criteria; // Age range, experience, etc.

    private LocalDateTime createdAt;
}
