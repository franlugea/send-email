package com.spring.mail.sender.DTO;

import org.springframework.web.multipart.MultipartFile;


public record EmailFileDTO(
        String [] toUser,
        String Subject,
        String message,
        MultipartFile file
) {
}
