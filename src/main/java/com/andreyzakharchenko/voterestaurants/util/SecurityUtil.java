package com.andreyzakharchenko.voterestaurants.util;

import com.andreyzakharchenko.voterestaurants.model.AbstractBaseEntity;

public class SecurityUtil {

    private static int id = AbstractBaseEntity.START_SEQ;
    public static int authUserId() {
        return id;
    }
}
