package baby.ey.aduio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AudioCollectionAPI {

    public static void main(String[] args) {
        SpringApplication.run(AudioCollectionAPI.class, args);
    }

    @PostMapping("/audio")
    public ResponseEntity<String> receiveAudioData(@RequestBody byte[] audioData) {
        // 여기서는 받은 오디오 데이터를 AI 모델을 가진 개발자에게 전달하는 작업을 수행합니다.
        // 이 예시에서는 받은 데이터를 콘솔에 출력하는 것으로 대체합니다.
        System.out.println("Received audio data: " + audioData.length + " bytes");

        // 성공적으로 데이터를 받았음을 클라이언트에게 응답합니다.
        return ResponseEntity.status(HttpStatus.OK).body("Audio data received successfully");
    }
}
