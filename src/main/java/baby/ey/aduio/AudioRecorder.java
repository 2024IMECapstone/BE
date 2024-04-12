package baby.ey.aduio;

import javax.sound.sampled.*;

public class AudioRecorder {
    private AudioFormat audioFormat;
    private TargetDataLine targetDataLine;

    public AudioRecorder() {
        audioFormat = new AudioFormat(44100, 16, 2, true, true); // 샘플 레이트, 비트, 채널, signed, big-endian 설정
    }

    public void start() {
        try {
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            targetDataLine.open(audioFormat);
            targetDataLine.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        targetDataLine.stop();
        targetDataLine.close();
    }

    public byte[] read() {
        byte[] buffer = new byte[1024];
        int bytesRead = targetDataLine.read(buffer, 0, buffer.length);
        return buffer;
    }
}

