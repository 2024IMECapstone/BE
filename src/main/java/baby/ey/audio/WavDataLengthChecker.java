package baby.ey.audio;

import java.io.*;

public class WavDataLengthChecker {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\smyj0\\study\\hello-spirng\\BE\\recordedAudio.wav";

        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            // "data" 청크 위치로 이동
            file.seek(36); // "RIFF" 헤더 크기(4바이트) + "WAVE" 헤더 크기(4바이트) + "fmt " 헤더 크기(4바이트) + "fmt " 데이터 크기(4바이트) + "data" 헤더 크기(4바이트)

            // "data" 청크 헤더 읽기
            byte[] dataHeader = new byte[4];
            file.read(dataHeader);
            String dataHeaderStr = new String(dataHeader, "UTF-8");

            // "data" 청크 헤더가 "data"인지 확인
            if (!dataHeaderStr.equals("data")) {
                System.out.println("Invalid WAV file format. 'data' chunk not found.");
                return;
            }

            // "data" 청크 크기 읽기
            int dataChunkSize = Integer.reverseBytes(file.readInt());
            System.out.println("오디오 데이터 길이: " + dataChunkSize + " 바이트");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
