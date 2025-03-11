package tn.esprit.castini.service;

import tn.esprit.castini.entity.MarketingAnalytics;

import java.util.List;
import java.util.Optional;

public interface IMarketingAnalyticsService {
    List<MarketingAnalytics> getAllMarketingAnalytics();
    Optional<MarketingAnalytics> getMarketingAnalyticsById(Long id);
    List<MarketingAnalytics> getAnalyticsByCampaign(Long campaignId);
    MarketingAnalytics createMarketingAnalytics(MarketingAnalytics marketingAnalytics);
    MarketingAnalytics updateMarketingAnalytics(Long id, MarketingAnalytics marketingAnalytics);
    void deleteMarketingAnalytics(Long id);
}
