package tn.esprit.castini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.castini.entity.MarketingTarget;

import java.util.List;

@Repository
public interface MarketingTargetRepository extends JpaRepository<MarketingTarget, Long> {
    List<MarketingTarget> findByCampaignId(Long campaignId);
}
