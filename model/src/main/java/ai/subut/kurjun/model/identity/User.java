package ai.subut.kurjun.model.identity;


import java.util.Date;


/**
 *
 */
public interface User
{
    String getKeyId();

    String getKeyFingerprint();

    Date getDate();

    String getEmailAddress();

    String getSharedSecret();

    void setSharedSecret( String sharedSecret );

    String getSignature();

    void setSignature( String signature );

    //*************************
    String getKeyData();

    //*************************
    void setKeyData( String keyData );

    //*************************
    String getToken();

    //*************************
    void setToken( String token );
}
