package tn.esprit.castini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.castini.entity.Campaign;
import tn.esprit.castini.entity.MarketingTarget;
import tn.esprit.castini.repository.CampaignRepository;
import tn.esprit.castini.repository.MarketingTargetRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MarketingTargetServiceImpl implements IMarketingTargetService {

    @Autowired
    private MarketingTargetRepository marketingTargetRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public List<MarketingTarget> getAllMarketingTargets() {
        return marketingTargetRepository.findAll();
    }

    @Override
    public Optional<MarketingTarget> getMarketingTargetById(Long id) {
        return marketingTargetRepository.findById(id);
    }

    @Override
    public List<MarketingTarget> getTargetsByCampaign(Long campaignId) {
        return marketingTargetRepository.findByCampaignId(campaignId);
    }

    @Override
    public MarketingTarget createMarketingTarget(MarketingTarget marketingTarget) {
        if (marketingTarget.getCampaign() == null || marketingTarget.getCampaign().getId() == null) {
            throw new RuntimeException("Campaign ID is required");
        }

        // Fetch the campaign from DB to ensure it exists
        Campaign campaign = campaignRepository.findById(marketingTarget.getCampaign().getId())
                .orElseThrow(() -> new RuntimeException("Campaign not found with ID: " + marketingTarget.getCampaign().getId()));

        // Set the fetched campaign
        marketingTarget.setCampaign(campaign);
        marketingTarget.setCreatedAt(LocalDateTime.now());

        return marketingTargetRepository.save(marketingTarget);
    }

    @Override
    public MarketingTarget updateMarketingTarget(Long id, MarketingTarget marketingTarget) {
        if (!marketingTargetRepository.existsById(id)) {
            throw new RuntimeException("Marketing Target not found with id: " + id);
        }
        marketingTarget.setId(id);
        return marketingTargetRepository.save(marketingTarget);
    }

    @Override
    public void deleteMarketingTarget(Long id) {
        if (!marketingTargetRepository.existsById(id)) {
            throw new RuntimeException("Marketing Target not found with id: " + id);
        }
        marketingTargetRepository.deleteById(id);
    }
}
