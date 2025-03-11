package tn.esprit.castini.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.castini.entity.Campaign;
import tn.esprit.castini.service.ICampaignService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/campaign")
public class CampaignRestController {

    @Autowired
    private ICampaignService campaignService;

    // Retrieve all campaigns
    @GetMapping("/retrieve-all-campaigns")
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    // Retrieve a campaign by its ID
    @GetMapping("/retrieve-campaign/{campaign-id}")
    public Campaign retrieveCampaign(@PathVariable("campaign-id") Long idCampaign) {
        Optional<Campaign> campaign = campaignService.getCampaignById(idCampaign);
        return campaign.orElseThrow(() -> new RuntimeException("Campaign not found with ID: " + idCampaign));
    }

    // Add a new campaign
    @PostMapping("/add-campaign")
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }

    // Delete a campaign by its ID
    @DeleteMapping("/delete-campaign/{campaign-id}")
    public void deleteCampaign(@PathVariable("campaign-id") Long idCampaign) {
        campaignService.deleteCampaign(idCampaign);
    }

    // Update an existing campaign
    @PutMapping("/modify-campaign")
    public Campaign updateCampaign(@RequestBody Campaign campaign) {
        return campaignService.updateCampaign(campaign.getId(), campaign);
    }
}
