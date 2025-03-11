package tn.esprit.castini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.castini.entity.Campaign;
import tn.esprit.castini.entity.SocialMediaPost;
import tn.esprit.castini.repository.CampaignRepository;
import tn.esprit.castini.repository.SocialMediaPostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SocialMediaPostServiceImpl implements ISocialMediaPostService {

    @Autowired
    private SocialMediaPostRepository socialMediaPostRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public List<SocialMediaPost> getAllSocialMediaPosts() {
        return socialMediaPostRepository.findAll();
    }

    @Override
    public Optional<SocialMediaPost> getSocialMediaPostById(Long id) {
        return socialMediaPostRepository.findById(id);
    }

    @Override
    public List<SocialMediaPost> getPostsByCampaign(Long campaignId) {
        return socialMediaPostRepository.findByCampaignId(campaignId);
    }

    @Override
    public SocialMediaPost createSocialMediaPost(SocialMediaPost socialMediaPost) {
        if (socialMediaPost.getCampaign() == null || socialMediaPost.getCampaign().getId() == null) {
            throw new RuntimeException("Campaign ID is required");
        }

        // Fetch the campaign from DB to ensure it exists
        Campaign campaign = campaignRepository.findById(socialMediaPost.getCampaign().getId())
                .orElseThrow(() -> new RuntimeException("Campaign not found with ID: " + socialMediaPost.getCampaign().getId()));

        // Set the fetched campaign
        socialMediaPost.setCampaign(campaign);
        socialMediaPost.setCreatedAt(LocalDateTime.now());

        return socialMediaPostRepository.save(socialMediaPost);
    }

    @Override
    public SocialMediaPost updateSocialMediaPost(Long id, SocialMediaPost socialMediaPost) {
        if (!socialMediaPostRepository.existsById(id)) {
            throw new RuntimeException("Social Media Post not found with id: " + id);
        }
        socialMediaPost.setId(id);
        return socialMediaPostRepository.save(socialMediaPost);
    }

    @Override
    public void deleteSocialMediaPost(Long id) {
        if (!socialMediaPostRepository.existsById(id)) {
            throw new RuntimeException("Social Media Post not found with id: " + id);
        }
        socialMediaPostRepository.deleteById(id);
    }
}
