package tn.esprit.castini.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.castini.entity.SocialMediaPost;
import tn.esprit.castini.service.ISocialMediaPostService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/social-media-post")
public class SocialMediaPostRestController {

    @Autowired
    private ISocialMediaPostService socialMediaPostService;

    // Retrieve all social media posts
    @GetMapping("/retrieve-all")
    public List<SocialMediaPost> getAllSocialMediaPosts() {
        return socialMediaPostService.getAllSocialMediaPosts();
    }

    // Retrieve social media post by ID
    @GetMapping("/retrieve/{id}")
    public SocialMediaPost retrieveSocialMediaPost(@PathVariable Long id) {
        Optional<SocialMediaPost> socialMediaPost = socialMediaPostService.getSocialMediaPostById(id);
        return socialMediaPost.orElseThrow(() -> new RuntimeException("Social Media Post not found with ID: " + id));
    }

    // Retrieve posts by campaign ID
    @GetMapping("/campaign/{campaignId}")
    public List<SocialMediaPost> getPostsByCampaign(@PathVariable Long campaignId) {
        return socialMediaPostService.getPostsByCampaign(campaignId);
    }

    // Add a new social media post
    @PostMapping("/add")
    public SocialMediaPost addSocialMediaPost(@RequestBody SocialMediaPost socialMediaPost) {
        return socialMediaPostService.createSocialMediaPost(socialMediaPost);
    }

    // Delete social media post by ID
    @DeleteMapping("/delete/{id}")
    public void deleteSocialMediaPost(@PathVariable Long id) {
        socialMediaPostService.deleteSocialMediaPost(id);
    }

    // Update an existing social media post
    @PutMapping("/modify")
    public SocialMediaPost updateSocialMediaPost(@RequestBody SocialMediaPost socialMediaPost) {
        return socialMediaPostService.updateSocialMediaPost(socialMediaPost.getId(), socialMediaPost);
    }
}
