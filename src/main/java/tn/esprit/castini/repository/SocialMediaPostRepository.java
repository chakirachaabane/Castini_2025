package tn.esprit.castini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.castini.entity.SocialMediaPost;

import java.util.List;

@Repository
public interface SocialMediaPostRepository extends JpaRepository<SocialMediaPost, Long> {
    List<SocialMediaPost> findByCampaignId(Long campaignId);
}
