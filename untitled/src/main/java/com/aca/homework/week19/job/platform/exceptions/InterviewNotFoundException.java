package com.aca.homework.week19.job.platform.exceptions;

public class InterviewNotFoundException extends RuntimeException {

    public InterviewNotFoundException(Long interviewId) {
        super(String.format("the interview with id %d not found", interviewId));
    }
}
