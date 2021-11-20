package com.andreyzakharchenko.voterestaurants.web.voteuser;

import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import com.andreyzakharchenko.voterestaurants.service.VoteUserService;
import com.andreyzakharchenko.voterestaurants.util.SecurityUtil;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VoteUserRestController {

    //private static final Logger log = LoggerFactory.getLogger(VoteUserRestController.class);

    private final VoteUserService service;

    public VoteUserRestController(VoteUserService service) {
        this.service = service;
    }

    public List<VoteUser> getAll() {
        int userId = SecurityUtil.authUserId();
        //log.info("getAll for user {}", userId);
        return service.getAll(userId);
    }
}
