package tn.esprit.castini.service;

import tn.esprit.castini.entity.InfluencerCollaboration;

import java.util.List;
import java.util.Optional;

public interface IInfluencerCollaborationService {
    List<InfluencerCollaboration> getAllInfluencerCollaborations();
    Optional<InfluencerCollaboration> getInfluencerCollaborationById(Long id);
    List<InfluencerCollaboration> getCollaborationsByCampaign(Long campaignId);
    InfluencerCollaboration createInfluencerCollaboration(InfluencerCollaboration influencerCollaboration);
    InfluencerCollaboration updateInfluencerCollaboration(Long id, InfluencerCollaboration influencerCollaboration);
    void deleteInfluencerCollaboration(Long id);
}
