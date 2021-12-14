package com.andreyzakharchenko.voterestaurants.web.voteuser;

import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import com.andreyzakharchenko.voterestaurants.service.VoteUserService;
import com.andreyzakharchenko.voterestaurants.util.SecurityUtil;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.andreyzakharchenko.voterestaurants.util.ValidationUtil.assureIdConsistent;

@Controller
public class VoteUserRestController {

    //private static final Logger log = LoggerFactory.getLogger(VoteUserRestController.class);

    private final VoteUserService service;

    public VoteUserRestController(VoteUserService service) {
        this.service = service;
    }

    public VoteUser create(VoteUser voteUser, int launchMenuID) {
        int userId = SecurityUtil.authUserId();
        //log.info("update {} for user {}", meal, userId);
        System.out.println("create");
        return service.create(voteUser, userId, launchMenuID);
    }

    public List<VoteUser> getAll() {
        int userId = SecurityUtil.authUserId();
        //log.info("getAll for user {}", userId);
        return service.getAll(userId);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        //log.info("delete meal {} for user {}", id, userId);
        service.delete(id, userId);
    }
}
