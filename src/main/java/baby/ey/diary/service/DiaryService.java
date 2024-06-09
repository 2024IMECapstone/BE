package baby.ey.diary.service;

import baby.ey.diary.dto.AnalysisResultDto;
import baby.ey.diary.dto.DiaryRequestsDto;
import baby.ey.diary.dto.DiaryResponseDto;
import baby.ey.diary.dto.SuccessResponseDto;
import baby.ey.diary.entity.Diary;
import baby.ey.diary.repository.DiaryRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final AmazonS3 amazonS3;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private String changedImageName(String originName) {
        String random = UUID.randomUUID().toString();
        return "diary/" + random + originName;
    }

    private String uploadImageToS3(MultipartFile image) throws IOException {
        if (image == null || image.isEmpty()) {
            return null;
        }
        String originName = image.getOriginalFilename();
        String ext = originName.substring(originName.lastIndexOf("."));
        String changedName = changedImageName(originName);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/" + ext);
        amazonS3.putObject(new PutObjectRequest(bucket, changedName, image.getInputStream(), metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3.getUrl(bucket, changedName).toString();
    }

    @Transactional(readOnly = true)
    public List<DiaryResponseDto> getDiary() {
        return diaryRepository.findAllByOrderByCreatedDesc().stream()
                .map(DiaryResponseDto::new).toList();
    }

/*
    @Transactional
    public DiaryResponseDto createDiary(MultipartFile image, DiaryRequestsDto requestDto) throws IOException {
        String imagePath = uploadImageToS3(image);
        if (imagePath != null) {
            requestDto.setPath(imagePath);
        }
        Diary diary = new Diary(requestDto);
        diaryRepository.save(diary);
        return new DiaryResponseDto(diary);
    }

 */
    @Transactional
    public DiaryResponseDto createDiary(DiaryRequestsDto requestDto) {
        Diary diary = new Diary(requestDto);
        diaryRepository.save(diary);
        return new DiaryResponseDto(diary);
    }

    @Transactional
    public DiaryResponseDto getDiary(Long id) {
        return diaryRepository.findById(id).map(DiaryResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다.")
        );
    }

    /*
    @Transactional
    public DiaryResponseDto updateDiary(Long id, MultipartFile image, DiaryRequestsDto requestsDto) throws Exception {
        Diary diary = diaryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다.")
        );
        String imagePath = uploadImageToS3(image);
        if (imagePath != null) {
            requestsDto.setPath(imagePath);
        }
        diary.update(requestsDto);
        return new DiaryResponseDto(diary);
    }

     */

    @Transactional
    public DiaryResponseDto updateDiary(Long id, DiaryRequestsDto requestsDto) throws Exception {
        Diary diary = diaryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다.")
        );
        //String imagePath = uploadImageToS3(image);
        /*if (imagePath != null) {
            requestsDto.setPath(imagePath);
        }
         */
        diary.update(requestsDto);
        return new DiaryResponseDto(diary);
    }

    @Transactional
    public SuccessResponseDto deleteDiary(Long id) throws Exception {
        diaryRepository.deleteById(id);
        return new SuccessResponseDto(true);
    }

    @Transactional(readOnly = true)
    public String getLatestDiaryContent() {
        return diaryRepository.findTopByOrderByCreatedDesc()
                .map(Diary::getContent)
                .orElseThrow(() -> new IllegalArgumentException("일기가 존재하지 않습니다."));
    }

    @Transactional
    public void processAnalysisResult(AnalysisResultDto analysisResultDto) {
        // 분석 결과를 처리하는 로직 추가
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "/Users/eunseo/Desktop/studyspring/5ey/src/main/java/baby/ey/diary/analysis_result.json";

        try {
            // AnalysisResultDto 객체를 JSON 문자열로 변환
            String jsonString = objectMapper.writeValueAsString(analysisResultDto);

            // JSON 문자열을 파일에 저장
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 추가 로직 작성...
    }
}
