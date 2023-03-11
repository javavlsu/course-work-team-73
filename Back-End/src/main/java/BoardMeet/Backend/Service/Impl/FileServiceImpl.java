package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Value("${upload.path}")
    private String UPLOAD_DIRECTORY;
    @Override
    public String uploadAvatar(MultipartFile avatar) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        fileNames.append(UUID.randomUUID().toString() + getFileExtension(avatar.getOriginalFilename()));
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY + "/avatar", fileNames.toString());
        Files.write(fileNameAndPath, avatar.getBytes());
        return fileNames.toString();
    }

    private static String getFileExtension(String mystr) {
        int index = mystr.indexOf('.');
        return index == -1? null : mystr.substring(index);
    }
}
