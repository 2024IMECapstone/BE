package baby.ey.diary.service;


import baby.ey.diary.dto.GrowthResponseDto;
import baby.ey.diary.dto.MealResponseDto;
import baby.ey.diary.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    @Transactional(readOnly = true)
    public List<MealResponseDto> getMeal() {
        return mealRepository.findAllByOrderByCreatedDesc().stream()
                .map(MealResponseDto::new).toList();
    }

    @Transactional
    public MealResponseDto getMeal(Long id) {
        return mealRepository.findById(id).map(MealResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다")
        );
    }
}
