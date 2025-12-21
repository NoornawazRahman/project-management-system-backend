package com.mnrahman.service;

import com.mnrahman.entity.Invitation;
import jakarta.mail.MessagingException;

public interface InvitationService {
    void sendInvitation(String email, Long projectId) throws MessagingException;

    Invitation acceptyInvitation(String token, Long userId) throws Exception;

    String getTokenByUserMail(String userEmail);

    void deleteToken(String token);
}
