package com.spring.mail.sender.Controller;

import com.spring.mail.sender.DTO.EmailDTO;
import com.spring.mail.sender.DTO.EmailFileDTO;
import com.spring.mail.sender.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/apiEmail")
public class Controler {

    @Autowired
    public MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<String> reciveRequestEmail(@RequestBody EmailDTO emailDTO){
        mailService.sendEmail(emailDTO.toUser(),emailDTO.Subject(),emailDTO.message());
        return  ResponseEntity.ok("Email enviado");
    }

    @PostMapping("/sendFile")
    public ResponseEntity<String> reciveRequestEmailFile(@ModelAttribute EmailFileDTO emailFileDTO){
        try {
            String fileName= emailFileDTO.file().getOriginalFilename();
            Path path= Paths.get("src/main/resources/file",fileName);
            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.file().getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
            File file=path.toFile();

            mailService.sendEmailFile(emailFileDTO.toUser(),emailFileDTO.Subject(),emailFileDTO.message(),file);
        }catch (IOException e){
            e.printStackTrace();
        }
        return  ResponseEntity.ok("Email enviado");
    }
}
