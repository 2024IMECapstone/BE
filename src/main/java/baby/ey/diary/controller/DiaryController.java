package baby.ey.diary.controller;

import baby.ey.diary.dto.AnalysisResultDto;
import baby.ey.diary.dto.DiaryRequestsDto;
import baby.ey.diary.dto.DiaryResponseDto;
import baby.ey.diary.dto.SuccessResponseDto;
import baby.ey.diary.service.DiaryService;
import baby.ey.diary.service.JsonToDatabaseService;
import baby.ey.upload.service.AwsS3Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@Tag(name = "Diary", description = "육아일기 API")
public class DiaryController {
    private final DiaryService diaryService;
    private final AwsS3Service awsS3Service;
    private final ObjectMapper objectMapper;
    private JsonToDatabaseService jsonToDatabaseService;


    @GetMapping("/api/diary")
    @Operation(summary = "육아일기 조회", description = "육아일기 조회 후 리스트 반환 API")
    public List<DiaryResponseDto> getDiary() {
        return diaryService.getDiary();
    }

    /*
    @PostMapping("/api/post")
    @Operation(summary = "육아일기 작성", description = "육아일기 작성 API")
    public DiaryResponseDto createDiary(@RequestPart(value = "image", required = false) MultipartFile image, @Valid @RequestPart(value = "requestDto") DiaryRequestsDto requestDto) throws IOException {
        return diaryService.createDiary(image, requestDto);
    }
     */

    @PostMapping("/api/post")
    @Operation(summary = "육아일기 작성", description = "육아일기 작성 API")
    public DiaryResponseDto createDiary(@RequestBody DiaryRequestsDto requestDto) {
        return diaryService.createDiary(requestDto);
    }

    @GetMapping("/api/diary/{id}")
    @Operation(summary = "육아일기 상세 조회", description = "육아일기 상세 조회 API")
    public DiaryResponseDto getDiary(@PathVariable Long id) throws Exception {
        return diaryService.getDiary(id);
    }

    /*
    @PutMapping("/api/diary/{id}")
    @Operation(summary = "육아일기 수정", description = "육아일기 내용 및 이미지 변경 API, 변경 날짜 자동 저장")
    public DiaryResponseDto updateDiary(@PathVariable Long id, @RequestPart(value = "image", required = false) MultipartFile image, @Valid @RequestPart(value = "requestDto") DiaryRequestsDto requestDto) throws Exception {
        return diaryService.updateDiary(id, image, requestDto);
    }

     */

    @PutMapping("/api/diary/{id}")
    @Operation(summary = "육아일기 수정", description = "육아일기 내용 및 이미지 변경 API, 변경 날짜 자동 저장")
    public DiaryResponseDto updateDiary(@PathVariable Long id, @RequestBody DiaryRequestsDto requestDto) throws Exception {
        return diaryService.updateDiary(id, requestDto);
    }


    @DeleteMapping("/api/diary/{id}")
    @Operation(summary = "육아일기 삭제", description = "선택한 육아일기 삭제 API")
    public SuccessResponseDto deleteDiary(@PathVariable Long id) throws Exception {
        return diaryService.deleteDiary(id);
    }

    @GetMapping("/api/diary/latest")
    @Operation(summary = "가장 최근의 육아일기 조회", description = "가장 최근의 육아일기 내용을 반환하는 API")
    public Map<String, String> getLatestDiaryContent() {
        String latestContent = diaryService.getLatestDiaryContent();
        Map<String, String> response = new HashMap<>();
        response.put("content", latestContent);
        return response;
    }

    @PostMapping("/api/analysis")
    @Operation(summary = "분석 결과 수신", description = "Flask 애플리케이션으로부터 분석 결과를 수신하는 API")
    public Map<String, String> receiveAnalysisResult(@RequestBody AnalysisResultDto analysisResultDto) {
        System.out.println("Received Analysis Result: " + analysisResultDto);

        String filePath = "/Users/eunseo/Desktop/studyspring/5ey/src/main/java/baby/ey/diary/analysis_result.json";
        try (FileWriter file = new FileWriter(filePath)) {
            // JSON 형식으로 저장
            String jsonString = objectMapper.writeValueAsString(analysisResultDto);
            file.write(jsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
            Map<String, String> response = new HashMap<>();
            response.put("status", "failure");
            response.put("message", "Failed to save analysis result");
            return response;
        }

        diaryService.processAnalysisResult(analysisResultDto);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }

    @PostMapping("/upload-json")
    public ResponseEntity<String> uploadJson(@RequestParam("filePath") String filePath) {
        try {
            jsonToDatabaseService.saveJsonToDatabase(filePath);
            return ResponseEntity.ok("JSON data saved to database successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

}
