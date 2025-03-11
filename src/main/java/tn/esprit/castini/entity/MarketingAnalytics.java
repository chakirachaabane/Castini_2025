package tn.esprit.castini.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "marketing_analytics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketingAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    @JsonBackReference
    private Campaign campaign;

    private int totalViews;
    private int totalClicks;
    private int totalConversions;

    @Column(precision = 5, scale = 2)
    private BigDecimal engagementRate; // %

    @Column(precision = 10, scale = 2)
    private BigDecimal roi; // Return on investment

    private LocalDateTime reportDate;
    private LocalDateTime createdAt;
}
