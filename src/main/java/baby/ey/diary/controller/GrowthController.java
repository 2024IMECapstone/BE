package baby.ey.diary.controller;

import baby.ey.diary.dto.GrowthResponseDto;
import baby.ey.diary.service.GrowthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Growth", description = "성장 키워드 API")
public class GrowthController {
    private final GrowthService growthService;

    @GetMapping("/api/growth")
    @Operation(summary = "성장 키워드 조회", description = "성장 키워드 조회 후 리스트 반환 API")
    public List<GrowthResponseDto> getGrowth() {
        return growthService.getGrowth();
    }

    @GetMapping("/api/growth/{id}")
    @Operation(summary = "성장 키워드 상세 조회", description = "성장 키워드 상세 조회 API")
    public GrowthResponseDto getGrowth(@PathVariable Long id) throws Exception {
        return growthService.getGrowth(id);
    }
}
