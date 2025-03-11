package tn.esprit.castini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.castini.entity.Campaign;
import tn.esprit.castini.entity.MarketingAnalytics;
import tn.esprit.castini.repository.CampaignRepository;
import tn.esprit.castini.repository.MarketingAnalyticsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MarketingAnalyticsServiceImpl implements IMarketingAnalyticsService {

    @Autowired
    private MarketingAnalyticsRepository marketingAnalyticsRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public List<MarketingAnalytics> getAllMarketingAnalytics() {
        return marketingAnalyticsRepository.findAll();
    }

    @Override
    public Optional<MarketingAnalytics> getMarketingAnalyticsById(Long id) {
        return marketingAnalyticsRepository.findById(id);
    }

    @Override
    public List<MarketingAnalytics> getAnalyticsByCampaign(Long campaignId) {
        return marketingAnalyticsRepository.findByCampaignId(campaignId);
    }

    @Override
    public MarketingAnalytics createMarketingAnalytics(MarketingAnalytics marketingAnalytics) {
        if (marketingAnalytics.getCampaign() == null || marketingAnalytics.getCampaign().getId() == null) {
            throw new RuntimeException("Campaign ID is required");
        }

        // Fetch the campaign from DB to ensure it exists
        Campaign campaign = campaignRepository.findById(marketingAnalytics.getCampaign().getId())
                .orElseThrow(() -> new RuntimeException("Campaign not found with ID: " + marketingAnalytics.getCampaign().getId()));

        // Set the fetched campaign
        marketingAnalytics.setCampaign(campaign);
        marketingAnalytics.setCreatedAt(LocalDateTime.now());

        return marketingAnalyticsRepository.save(marketingAnalytics);
    }

    @Override
    public MarketingAnalytics updateMarketingAnalytics(Long id, MarketingAnalytics marketingAnalytics) {
        if (!marketingAnalyticsRepository.existsById(id)) {
            throw new RuntimeException("Marketing Analytics not found with id: " + id);
        }
        marketingAnalytics.setId(id);
        return marketingAnalyticsRepository.save(marketingAnalytics);
    }

    @Override
    public void deleteMarketingAnalytics(Long id) {
        if (!marketingAnalyticsRepository.existsById(id)) {
            throw new RuntimeException("Marketing Analytics not found with id: " + id);
        }
        marketingAnalyticsRepository.deleteById(id);
    }
}
