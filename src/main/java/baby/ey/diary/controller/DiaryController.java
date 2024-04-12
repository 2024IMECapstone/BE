package baby.ey.diary.controller;

import baby.ey.diary.dto.DiaryRequestsDto;
import baby.ey.diary.dto.DiaryResponseDto;
import baby.ey.diary.dto.SuccessResponseDto;
import baby.ey.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @GetMapping("/api/diary")
    public List<DiaryResponseDto> getDiary() {
        return diaryService.getDiary();
    }

    @PostMapping("/api/post")
    public DiaryResponseDto createDiary(@RequestBody DiaryRequestsDto requestDto) {
        return diaryService.createDiary(requestDto);
    }

    @GetMapping("/api/diary/{id}")
    public DiaryResponseDto getDiary(@PathVariable Long id) {
        return diaryService.getDiary(id);
    }

    @PutMapping("/api/diary/{id}")
    public DiaryResponseDto updateDiary(@PathVariable Long id, @RequestBody DiaryRequestsDto requestDto) throws Exception {
        return diaryService.updateDiary(id, requestDto);
    }

    @DeleteMapping("/api/diary/{id}")
    public SuccessResponseDto deleteDiary(@PathVariable Long id, @RequestBody DiaryRequestsDto requestDto) throws Exception {
        return diaryService.deleteDiary(id, requestDto);
    }


}
