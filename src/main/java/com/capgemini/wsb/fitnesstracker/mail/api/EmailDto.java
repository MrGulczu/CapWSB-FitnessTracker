package com.capgemini.wsb.fitnesstracker.mail.api;

/**
 * Data transfer object (DTO) representing an email.
 */
public record EmailDto(String toAddress, String subject, String content) {

}
