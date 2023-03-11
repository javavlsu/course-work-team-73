package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    public static String UPLOAD_DIRECTORY = "C:/";
    @Override
    public String uploadAvatar(MultipartFile avatar) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, avatar.getOriginalFilename());
        fileNames.append(avatar.getOriginalFilename());
        Files.write(fileNameAndPath, avatar.getBytes());
        return fileNames.toString();
    }
}
