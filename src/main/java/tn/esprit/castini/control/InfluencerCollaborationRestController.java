package tn.esprit.castini.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.castini.entity.InfluencerCollaboration;
import tn.esprit.castini.service.IInfluencerCollaborationService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/influencer-collaboration")
public class InfluencerCollaborationRestController {

    @Autowired
    private IInfluencerCollaborationService influencerCollaborationService;

    // Retrieve all influencer collaborations
    @GetMapping("/retrieve-all")
    public List<InfluencerCollaboration> getAllInfluencerCollaborations() {
        return influencerCollaborationService.getAllInfluencerCollaborations();
    }

    // Retrieve an influencer collaboration by ID
    @GetMapping("/retrieve/{id}")
    public InfluencerCollaboration retrieveInfluencerCollaboration(@PathVariable Long id) {
        Optional<InfluencerCollaboration> collaboration = influencerCollaborationService.getInfluencerCollaborationById(id);
        return collaboration.orElseThrow(() -> new RuntimeException("Influencer Collaboration not found with ID: " + id));
    }

    // Retrieve collaborations by Campaign ID
    @GetMapping("/retrieve-by-campaign/{campaignId}")
    public List<InfluencerCollaboration> getCollaborationsByCampaign(@PathVariable Long campaignId) {
        return influencerCollaborationService.getCollaborationsByCampaign(campaignId);
    }

    // Add a new influencer collaboration
    @PostMapping("/add")
    public InfluencerCollaboration addInfluencerCollaboration(@RequestBody InfluencerCollaboration influencerCollaboration) {
        return influencerCollaborationService.createInfluencerCollaboration(influencerCollaboration);
    }


    // Update an existing influencer collaboration
    @PutMapping("/modify")
    public InfluencerCollaboration updateInfluencerCollaboration(@RequestBody InfluencerCollaboration influencerCollaboration) {
        return influencerCollaborationService.updateInfluencerCollaboration(influencerCollaboration.getId(), influencerCollaboration);
    }

    // Delete an influencer collaboration by ID
    @DeleteMapping("/delete/{id}")
    public void deleteInfluencerCollaboration(@PathVariable Long id) {
        influencerCollaborationService.deleteInfluencerCollaboration(id);
    }
}
