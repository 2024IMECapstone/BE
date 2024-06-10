package baby.ey.diary.service;

import baby.ey.diary.dto.DiaryResponseDto;
import baby.ey.diary.dto.GrowthResponseDto;
import baby.ey.diary.repository.GrowthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class GrowthService {
    private final GrowthRepository growthRepository;

    @Transactional(readOnly = true)
    public List<GrowthResponseDto> getGrowth() {
        return growthRepository.findAllByOrderByCreatedDesc().stream()
                .map(GrowthResponseDto::new).toList();
    }

    @Transactional
    public GrowthResponseDto getGrowth(Long id) {
        return growthRepository.findById(id).map(GrowthResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다")
        );
    }
}
