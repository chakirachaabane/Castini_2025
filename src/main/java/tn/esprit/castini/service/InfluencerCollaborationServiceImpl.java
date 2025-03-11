package tn.esprit.castini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.castini.entity.Campaign;
import tn.esprit.castini.entity.InfluencerCollaboration;
import tn.esprit.castini.repository.CampaignRepository;
import tn.esprit.castini.repository.InfluencerCollaborationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InfluencerCollaborationServiceImpl implements IInfluencerCollaborationService {

    @Autowired
    private InfluencerCollaborationRepository influencerCollaborationRepository;

    @Autowired
    private CampaignRepository campaignRepository; // ✅ Injected CampaignRepository

    @Override
    public List<InfluencerCollaboration> getAllInfluencerCollaborations() {
        return influencerCollaborationRepository.findAll();
    }

    @Override
    public Optional<InfluencerCollaboration> getInfluencerCollaborationById(Long id) {
        return influencerCollaborationRepository.findById(id);
    }

    @Override
    public List<InfluencerCollaboration> getCollaborationsByCampaign(Long campaignId) {
        return influencerCollaborationRepository.findByCampaignId(campaignId);
    }

    @Override
    public InfluencerCollaboration createInfluencerCollaboration(InfluencerCollaboration influencerCollaboration) {
        if (influencerCollaboration.getCampaign() == null || influencerCollaboration.getCampaign().getId() == null) {
            throw new RuntimeException("Campaign ID is required");
        }

        // ✅ Fetch the campaign from DB to ensure it exists
        Campaign campaign = campaignRepository.findById(influencerCollaboration.getCampaign().getId())
                .orElseThrow(() -> new RuntimeException("Campaign not found with ID: " + influencerCollaboration.getCampaign().getId()));

        // ✅ Set the fetched campaign before saving
        influencerCollaboration.setCampaign(campaign);
        influencerCollaboration.setCreatedAt(LocalDateTime.now());

        return influencerCollaborationRepository.save(influencerCollaboration);
    }

    @Override
    public InfluencerCollaboration updateInfluencerCollaboration(Long id, InfluencerCollaboration influencerCollaboration) {
        if (!influencerCollaborationRepository.existsById(id)) {
            throw new RuntimeException("Influencer Collaboration not found with id: " + id);
        }
        influencerCollaboration.setId(id);
        return influencerCollaborationRepository.save(influencerCollaboration);
    }

    @Override
    public void deleteInfluencerCollaboration(Long id) {
        if (!influencerCollaborationRepository.existsById(id)) {
            throw new RuntimeException("Influencer Collaboration not found with id: " + id);
        }
        influencerCollaborationRepository.deleteById(id);
    }
}
