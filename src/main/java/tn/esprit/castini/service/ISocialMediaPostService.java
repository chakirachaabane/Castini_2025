package tn.esprit.castini.service;

import tn.esprit.castini.entity.SocialMediaPost;

import java.util.List;
import java.util.Optional;

public interface ISocialMediaPostService {
    List<SocialMediaPost> getAllSocialMediaPosts();
    Optional<SocialMediaPost> getSocialMediaPostById(Long id);
    List<SocialMediaPost> getPostsByCampaign(Long campaignId);
    SocialMediaPost createSocialMediaPost(SocialMediaPost socialMediaPost);
    SocialMediaPost updateSocialMediaPost(Long id, SocialMediaPost socialMediaPost);
    void deleteSocialMediaPost(Long id);
}
