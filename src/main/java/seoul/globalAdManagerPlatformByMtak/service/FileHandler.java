package seoul.globalAdManagerPlatformByMtak.service;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import seoul.globalAdManagerPlatformByMtak.domain.AdImg;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FileHandler {
    public List<AdImg> parseFileInfo(
            Long adID,
            List<MultipartFile> multipartFiles
    ) throws Exception {
        List<AdImg> fileList = new ArrayList<>();
        if (multipartFiles.isEmpty()) {
            return fileList;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());

        String absolutePath = new File("").getAbsolutePath() + "\\";
        String path = "images/" + current_date;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (MultipartFile multipartFile : multipartFiles){
            if(!multipartFile.isEmpty()){
                String contentType = multipartFile.getContentType();
                String originalFileExtension;
                if (ObjectUtils.isEmpty(contentType)){
                    break;
                }
                else{
                    if(contentType.contains("image/jpeg")){
                        originalFileExtension = ".jpg";
                    }
                    else if(contentType.contains("image/png")){
                        originalFileExtension = ".png";
                    }
                    else if(contentType.contains("image/gif")){
                        originalFileExtension = ".gif";
                    }
                    else{
                        break;
                    }
                }
                String new_file_name = Long.toString(System.nanoTime()) + originalFileExtension;
                AdImg adImg = AdImg.builder()
                        .boardIdx(adID)
                        .fileName(multipartFile.getOriginalFilename())
                        .location(path + "/" + new_file_name)
                        .fileSize(multipartFile.getSize())
                        .build();
                fileList.add(adImg);

                // 저장된 파일로 변경하여 이를 보여주기 위함
                file = new File(absolutePath + path + "/" + new_file_name);
                multipartFile.transferTo(file);
            }
        }
        return fileList;
    }
}
