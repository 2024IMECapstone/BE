package baby.ey.upload.repository;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String upload(MultipartFile file, String destLocation);
}
