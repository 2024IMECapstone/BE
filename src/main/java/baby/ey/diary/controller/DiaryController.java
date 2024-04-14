package baby.ey.diary.controller;

import baby.ey.diary.dto.DiaryRequestsDto;
import baby.ey.diary.dto.DiaryResponseDto;
import baby.ey.diary.dto.SuccessResponseDto;
import baby.ey.diary.service.DiaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Diary", description = "육아일기 API")
public class DiaryController {
    private final DiaryService diaryService;

    @GetMapping("/api/diary")
    @Operation(summary = "육아일기 조회", description = "육아일기 조회 후 리스트 반환 API")
    public List<DiaryResponseDto> getDiary() {
        return diaryService.getDiary();
    }

    @PostMapping("/api/post")
    @Operation(summary = "육아일기 작성", description = "육아일기 작성 API")
    public DiaryResponseDto createDiary(@RequestBody DiaryRequestsDto requestDto) {
        return diaryService.createDiary(requestDto);
    }

    @GetMapping("/api/diary/{id}")
    @Operation(summary = "육아일기 상세 조회", description = "육아일기 상세 조회 API")
    public DiaryResponseDto getDiary(@PathVariable Long id) {
        return diaryService.getDiary(id);
    }

    @PutMapping("/api/diary/{id}")
    @Operation(summary = "육아일기 수정", description = "육아일기 내용 및 수정일 변경 API")
    public DiaryResponseDto updateDiary(@PathVariable Long id, @RequestBody DiaryRequestsDto requestDto) throws Exception {
        return diaryService.updateDiary(id, requestDto);
    }

    @DeleteMapping("/api/diary/{id}")
    @Operation(summary = "육아일기 삭제", description = "선택한 육아일기 삭제 API")
    public SuccessResponseDto deleteDiary(@PathVariable Long id, @RequestBody DiaryRequestsDto requestDto) throws Exception {
        return diaryService.deleteDiary(id, requestDto);
    }


}
