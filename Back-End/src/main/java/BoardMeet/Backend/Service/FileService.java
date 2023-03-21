package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NotAccessExtensionException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FileService {
    String uploadAvatar(MultipartFile avatar) throws IOException, NotAccessExtensionException;

    String uploadRule(MultipartFile rule )throws IOException, NotAccessExtensionException;

    String uploadBoardGameAvatar(MultipartFile avatar )throws IOException, NotAccessExtensionException;

}
