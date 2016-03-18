package ai.subut.kurjun.identity.service;


import java.util.Date;
import java.util.List;

import ai.subut.kurjun.model.identity.Permission;
import ai.subut.kurjun.model.identity.RelationObject;
import ai.subut.kurjun.model.identity.User;
import ai.subut.kurjun.model.identity.UserSession;
import ai.subut.kurjun.model.identity.UserToken;


/**
 *
 */
public interface IdentityManager
{
    //********************************************
    UserSession loginPublicUser();


    //********************************************
    UserSession loginUser( String fingerprint, String authMessage );


    //********************************************
    User authenticateUser( String fingerprint, String authMessage );


    //********************************************
    User authenticateByToken( String token );


    //********************************************
    User getUser( String fingerprint );


    //********************************************
    User addUser( String publicKeyASCII );


    //********************************************
    User addUser( String publicKeyASCII, int userType );


    //********************************************
    List<User> getAllUsers();


    //********************************************
    UserToken createUserToken( User user, String token, String secret, String issuer, Date validDate );


    //********************************************
    boolean hasPermmission( User user, RelationObject relationObject, Permission permission );


}
