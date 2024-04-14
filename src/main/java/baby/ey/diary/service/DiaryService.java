package baby.ey.diary.service;

import baby.ey.diary.dto.DiaryRequestsDto;
import baby.ey.diary.dto.DiaryResponseDto;
import baby.ey.diary.dto.SuccessResponseDto;
import baby.ey.diary.entity.Diary;
import baby.ey.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;

    @Transactional(readOnly = true)
    public List<DiaryResponseDto> getDiary() {
        return diaryRepository.findAllByOrderByCreatedDesc().stream()
                .map(DiaryResponseDto::new).toList();
    }

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

    @Transactional
    public DiaryResponseDto updateDiary(Long id, DiaryRequestsDto requestsDto) throws Exception {
        Diary diary = diaryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다.")
        );
        diary.update(requestsDto);
        return new DiaryResponseDto(diary);
    }

    @Transactional
    public SuccessResponseDto deleteDiary(Long id, DiaryRequestsDto diaryRequestsDto) throws Exception {
        Diary diary = diaryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다.")
        );
        diaryRepository.deleteById(id);
        return new SuccessResponseDto(true);
    }
}
