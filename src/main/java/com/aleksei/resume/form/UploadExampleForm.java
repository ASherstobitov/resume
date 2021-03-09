package com.aleksei.resume.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadExampleForm {

    private String name;
    private MultipartFile file;
}
