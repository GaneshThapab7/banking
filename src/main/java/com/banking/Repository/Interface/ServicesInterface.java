package com.banking.Repository.Interface;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface ServicesInterface {
    void uploadImage(MultipartFile photo, String filename, String folderName) throws Exception;

}
