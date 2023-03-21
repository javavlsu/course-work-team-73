package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Exception.NotAccessExtensionException;
import BoardMeet.Backend.Service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;
@Service
public class FileServiceImpl implements FileService {
    @Value("${upload.path}")
    private String UPLOAD_DIRECTORY;

    private  static  String[] accessImageExtension = new String[]{".jpeg", ".png", ".jpg", ".webp"};
    private  static  String[] accessRuleExtension = new String[]{".pdf"};
    @Override
    public String uploadAvatar(MultipartFile avatar) throws IOException, NotAccessExtensionException {
        StringBuilder fileNames = new StringBuilder();
        if( !(Arrays.asList(accessImageExtension).contains(getFileExtension(avatar.getOriginalFilename())))){
            throw new NotAccessExtensionException();
        }
        fileNames.append(UUID.randomUUID().toString() + getFileExtension(avatar.getOriginalFilename()));
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY + "/avatar", fileNames.toString());
        Files.write(fileNameAndPath, avatar.getBytes());
        return fileNames.toString();
    }
    @Override
    public String uploadRule(MultipartFile rule) throws IOException, NotAccessExtensionException {
        StringBuilder fileNames = new StringBuilder();
        if( !(Arrays.asList(accessRuleExtension).contains(getFileExtension(rule.getOriginalFilename())))){
            throw new NotAccessExtensionException();
        }
        fileNames.append(UUID.randomUUID().toString() + getFileExtension(rule.getOriginalFilename()));
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY + "/rule", fileNames.toString());
        Files.write(fileNameAndPath, rule.getBytes());
        return fileNames.toString();
    }
    @Override
    public String uploadBoardGameAvatar(MultipartFile avatar) throws IOException, NotAccessExtensionException {
        StringBuilder fileNames = new StringBuilder();
        if( !(Arrays.asList(accessImageExtension).contains(getFileExtension(avatar.getOriginalFilename())))){
            throw new NotAccessExtensionException();
        }
        fileNames.append(UUID.randomUUID().toString() + getFileExtension(avatar.getOriginalFilename()));
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY + "/bgAvatar", fileNames.toString());
        Files.write(fileNameAndPath, avatar.getBytes());
        return fileNames.toString();
    }
    private static String getFileExtension(String mystr) {
        int index = mystr.indexOf('.');
        return index == -1? null : mystr.substring(index);
    }
}
