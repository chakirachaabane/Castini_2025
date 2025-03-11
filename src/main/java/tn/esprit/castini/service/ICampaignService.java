package tn.esprit.castini.service;

import tn.esprit.castini.entity.Campaign;

import java.util.List;
import java.util.Optional;

public interface ICampaignService {
    List<Campaign> getAllCampaigns();
    Optional<Campaign> getCampaignById(Long id);
    Campaign createCampaign(Campaign campaign);
    Campaign updateCampaign(Long id, Campaign campaign);
    void deleteCampaign(Long id);
}
