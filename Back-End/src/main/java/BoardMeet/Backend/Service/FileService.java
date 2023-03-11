package BoardMeet.Backend.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FileService {
    String uploadAvatar(MultipartFile avatar) throws IOException;
}
