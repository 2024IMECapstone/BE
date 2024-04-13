package baby.ey.audio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WavHeaderReader {
    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\smyj0\\study\\hello-spirng\\BE\\recordedAudio.wav";
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            // RIFF 헤더 확인
            byte[] riffHeader = new byte[4];
            fis.read(riffHeader);
            String riffHeaderString = new String(riffHeader);
            if (!riffHeaderString.equals("RIFF")) {
                System.out.println("Not a valid WAV file.");
                return;
            }

            // 파일 크기 확인
            byte[] fileSizeBytes = new byte[4];
            fis.read(fileSizeBytes);
            int fileSize = ByteBuffer.wrap(fileSizeBytes).order(ByteOrder.LITTLE_ENDIAN).getInt();

            // WAVE 포맷 확인
            byte[] waveHeader = new byte[4];
            fis.read(waveHeader);
            String waveHeaderString = new String(waveHeader);
            if (!waveHeaderString.equals("WAVE")) {
                System.out.println("Not a valid WAV file.");
                return;
            }

            // 추가적인 헤더 정보 읽기...

            fis.close();

            // 헤더 정보 출력
            System.out.println("File size: " + fileSize);
            // 추가적인 헤더 정보 출력...

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
