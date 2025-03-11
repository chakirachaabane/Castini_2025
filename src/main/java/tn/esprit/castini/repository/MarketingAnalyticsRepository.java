package tn.esprit.castini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.castini.entity.MarketingAnalytics;

import java.util.List;

@Repository
public interface MarketingAnalyticsRepository extends JpaRepository<MarketingAnalytics, Long> {
    List<MarketingAnalytics> findByCampaignId(Long campaignId);
}
