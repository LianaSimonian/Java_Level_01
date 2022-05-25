package com.aca.homework.week19.job.platform.exceptions;

public class InvitationNotFoundException extends RuntimeException {
    
    public InvitationNotFoundException(Long invitationId) {
        super(String.format("invitation with id %d not found", invitationId));
    }
}
