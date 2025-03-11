package tn.esprit.castini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.castini.entity.InfluencerCollaboration;

import java.util.List;

@Repository
public interface InfluencerCollaborationRepository extends JpaRepository<InfluencerCollaboration, Long> {
    List<InfluencerCollaboration> findByCampaignId(Long campaignId);
}
