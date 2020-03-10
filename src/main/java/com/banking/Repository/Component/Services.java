package com.banking.Repository.Component;

import com.banking.Repository.Interface.ServicesInterface;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Services implements ServicesInterface {

    public void uploadImage(MultipartFile photo, String filename,String folderName)throws Exception {
        String folder ="D:\\Assignment\\banking\\Documents\\"+folderName+"\\";
        byte[] photoBytes = photo.getBytes();
        Path photoPath = Paths.get(folder+filename);
        if(Files.isDirectory(Paths.get(folder))){
            Files.write(photoPath,photoBytes);
        }
        else{
            File file = new File(folder);
            file.mkdir();
            Files.write(photoPath,photoBytes);
        }


    }
}
