package tn.esprit.castini.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.castini.entity.MarketingAnalytics;
import tn.esprit.castini.service.IMarketingAnalyticsService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/marketing-analytics")
public class MarketingAnalyticsRestController {

    @Autowired
    private IMarketingAnalyticsService marketingAnalyticsService;

    // Retrieve all marketing analytics
    @GetMapping("/retrieve-all")
    public List<MarketingAnalytics> getAllMarketingAnalytics() {
        return marketingAnalyticsService.getAllMarketingAnalytics();
    }

    // Retrieve marketing analytics by ID
    @GetMapping("/retrieve/{id}")
    public MarketingAnalytics retrieveMarketingAnalytics(@PathVariable Long id) {
        Optional<MarketingAnalytics> marketingAnalytics = marketingAnalyticsService.getMarketingAnalyticsById(id);
        return marketingAnalytics.orElseThrow(() -> new RuntimeException("Marketing Analytics not found with ID: " + id));
    }

    // Retrieve analytics by campaign ID
    @GetMapping("/campaign/{campaignId}")
    public List<MarketingAnalytics> getAnalyticsByCampaign(@PathVariable Long campaignId) {
        return marketingAnalyticsService.getAnalyticsByCampaign(campaignId);
    }

    // Add a new marketing analytics entry
    @PostMapping("/add")
    public MarketingAnalytics addMarketingAnalytics(@RequestBody MarketingAnalytics marketingAnalytics) {
        return marketingAnalyticsService.createMarketingAnalytics(marketingAnalytics);
    }

    // Delete marketing analytics by ID
    @DeleteMapping("/delete/{id}")
    public void deleteMarketingAnalytics(@PathVariable Long id) {
        marketingAnalyticsService.deleteMarketingAnalytics(id);
    }

    // Update an existing marketing analytics entry
    @PutMapping("/modify")
    public MarketingAnalytics updateMarketingAnalytics(@RequestBody MarketingAnalytics marketingAnalytics) {
        return marketingAnalyticsService.updateMarketingAnalytics(marketingAnalytics.getId(), marketingAnalytics);
    }
}
