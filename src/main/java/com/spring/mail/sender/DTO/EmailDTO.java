package com.spring.mail.sender.DTO;

public record EmailDTO(
        String [] toUser,
        String Subject,
        String message
) {
}
