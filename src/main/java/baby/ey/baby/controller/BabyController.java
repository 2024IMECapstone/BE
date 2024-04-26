package baby.ey.baby.controller;

import baby.ey.baby.dto.BabyRequestsDto;
import baby.ey.baby.dto.BabyResponseDto;
import baby.ey.baby.service.BabyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Baby", description = "아기 API")

public class BabyController {

    private final BabyService babyService;

    @GetMapping("/api/baby")
    @Operation(summary = "아기 조회", description = "아기 조회 후 리스트 반환 API")
    public List<BabyResponseDto> getBaby() {
        return babyService.getBaby();
    }

    @PostMapping("/api/register")
    @Operation(summary = "아기 등록", description = "아기 등록 API")
    public BabyResponseDto createBaby(@RequestBody BabyRequestsDto babyRequestsDto) {
        return babyService.createBaby(babyRequestsDto);
    }

    // 아기 정보 수정 나중에 추가

}
