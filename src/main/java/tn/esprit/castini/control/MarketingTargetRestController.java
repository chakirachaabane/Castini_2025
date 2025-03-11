package tn.esprit.castini.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.castini.entity.MarketingTarget;
import tn.esprit.castini.service.IMarketingTargetService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/marketing-target")
public class MarketingTargetRestController {

    @Autowired
    private IMarketingTargetService marketingTargetService;

    // Retrieve all marketing targets
    @GetMapping("/retrieve-all")
    public List<MarketingTarget> getAllMarketingTargets() {
        return marketingTargetService.getAllMarketingTargets();
    }

    // Retrieve marketing target by ID
    @GetMapping("/retrieve/{id}")
    public MarketingTarget retrieveMarketingTarget(@PathVariable Long id) {
        Optional<MarketingTarget> marketingTarget = marketingTargetService.getMarketingTargetById(id);
        return marketingTarget.orElseThrow(() -> new RuntimeException("Marketing Target not found with ID: " + id));
    }

    // Retrieve marketing targets by campaign ID
    @GetMapping("/campaign/{campaignId}")
    public List<MarketingTarget> getTargetsByCampaign(@PathVariable Long campaignId) {
        return marketingTargetService.getTargetsByCampaign(campaignId);
    }

    // Add a new marketing target
    @PostMapping("/add")
    public MarketingTarget addMarketingTarget(@RequestBody MarketingTarget marketingTarget) {
        return marketingTargetService.createMarketingTarget(marketingTarget);
    }

    // Delete marketing target by ID
    @DeleteMapping("/delete/{id}")
    public void deleteMarketingTarget(@PathVariable Long id) {
        marketingTargetService.deleteMarketingTarget(id);
    }

    // Update an existing marketing target
    @PutMapping("/modify")
    public MarketingTarget updateMarketingTarget(@RequestBody MarketingTarget marketingTarget) {
        return marketingTargetService.updateMarketingTarget(marketingTarget.getId(), marketingTarget);
    }
}
