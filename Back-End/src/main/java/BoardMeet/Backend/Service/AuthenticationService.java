package BoardMeet.Backend.Service;

import BoardMeet.Backend.DTO.AuthenticationRequestDTO;
import BoardMeet.Backend.DTO.AuthenticationResponseDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    AuthenticationResponseDTO login(AuthenticationRequestDTO requestDto);
}
