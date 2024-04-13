package baby.ey.audio;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class AudioRecorder {

    private static final AudioFormat FORMAT = new AudioFormat(44100, 16, 1, true, true);
    private static final int BUFFER_SIZE = 4096;
    private static final Duration RECORDING_DURATION = Duration.ofSeconds(7); // 녹음 시간 설정 (7초)

    public void recordAudio(String fileName) {
        try {
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, FORMAT);
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                return;
            }

            TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(FORMAT);
            line.start();

            // 녹음 시작 시간을 기록합니다.
            Instant startTime = Instant.now();

            // 새로운 디렉토리 경로를 설정합니다.
            String directoryPath = "C:\\Users\\smyj0\\audio_files";
            File directory = new File(directoryPath);

            // 디렉토리가 존재하지 않으면 생성합니다.
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // 파일 경로 설정
            String filePath = directoryPath + File.separator + fileName;

            // 녹음 시간 동안 오디오를 읽어들입니다.
            byte[] buffer = new byte[BUFFER_SIZE];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (Duration.between(startTime, Instant.now()).compareTo(RECORDING_DURATION) < 0) {
                int bytesRead = line.read(buffer, 0, buffer.length);
                if (bytesRead == -1) {
                    // 더 이상 데이터를 읽지 못하면 루프를 중단합니다.
                    break;
                }
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            // 오디오 데이터를 파일에 저장합니다.
            byte[] audioData = byteArrayOutputStream.toByteArray();
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioData)) {
                AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, FORMAT, audioData.length / FORMAT.getFrameSize());
                File audioFile = new File(filePath);
                AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, audioFile);
            }

            // 녹음이 끝나면 라인을 중지하고 닫습니다.
            line.stop();
            line.close();

            System.out.println("Recording stopped. Audio saved at: " + filePath);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AudioRecorder recorder = new AudioRecorder();
        recorder.recordAudio("recordedAudio.wav");
    }
}
