package tn.esprit.castini.service;

import tn.esprit.castini.entity.MarketingTarget;

import java.util.List;
import java.util.Optional;

public interface IMarketingTargetService {
    List<MarketingTarget> getAllMarketingTargets();
    Optional<MarketingTarget> getMarketingTargetById(Long id);
    List<MarketingTarget> getTargetsByCampaign(Long campaignId);
    MarketingTarget createMarketingTarget(MarketingTarget marketingTarget);
    MarketingTarget updateMarketingTarget(Long id, MarketingTarget marketingTarget);
    void deleteMarketingTarget(Long id);
}
