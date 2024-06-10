package baby.ey.diary.controller;

import baby.ey.diary.dto.GrowthResponseDto;
import baby.ey.diary.dto.SleepResponseDto;
import baby.ey.diary.service.SleepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Sleep", description = "수면 키워드 API")
public class SleepController {
    private final SleepService sleepService;

    @GetMapping("/api/sleep")
    @Operation(summary = "수면 키워드 조회", description = "수면 키워드 조회 후 리스트 반환 API")
    public List<SleepResponseDto> getSleep() {
        return sleepService.getSleep();
    }

    @GetMapping("/api/sleep/{id}")
    @Operation(summary = "수면 키워드 상세 조회", description = "수면 키워드 상세 조회 API")
    public SleepResponseDto getSleep(@PathVariable Long id) throws Exception {
        return sleepService.getSleep(id);
    }
}
