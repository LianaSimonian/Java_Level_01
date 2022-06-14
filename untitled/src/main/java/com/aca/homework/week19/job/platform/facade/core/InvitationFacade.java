package com.aca.homework.week19.job.platform.facade.core;

import com.aca.homework.week19.job.platform.dto.InvitationAcceptDto;
import com.aca.homework.week19.job.platform.dto.InvitationDetailsDto;
import com.aca.homework.week19.job.platform.dto.InvitationRejectDto;
import com.aca.homework.week19.job.platform.dto.InvitationRequestDto;

public interface InvitationFacade {

    InvitationDetailsDto sendInvitation(InvitationRequestDto dto);

    InvitationDetailsDto acceptInvitation(InvitationAcceptDto dto);

    InvitationDetailsDto rejectInvitation(InvitationRejectDto dto);
}