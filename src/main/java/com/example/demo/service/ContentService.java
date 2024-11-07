package com.example.demo.service;

import com.example.demo.dto.SaveDTO;
import com.example.demo.entity.ContentEntity;
import com.example.demo.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final ImageService imageService;

    // Service - Repository 연결
    public void saveContent(SaveDTO saveDTO) throws IOException {
        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setTitle(saveDTO.getTitle());
        contentEntity.setContent(saveDTO.getContent());
        contentEntity.setImageUrl(null);

        contentRepository.save(contentEntity);
    }

    public void saveImageUrl(String imageUrl) {
        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setImageUrl(imageUrl);
        contentRepository.save(contentEntity);
    }

    public List<ContentEntity> selectContent() {

        return contentRepository.findAll();
    }

    public ContentEntity selectOneContent(String id) {
        int to = Integer.parseInt(id);

        return contentRepository.findById(to);
    }

    public void deleteOneContent(String id) {
        int to = Integer.parseInt(id);

        contentRepository.deleteById(to);
    }

    // 기존값이 있을 경우 save을 한 경우는 JPA가 update 구문을 실행한다.
    public void updateOneContent(SaveDTO saveDTO, String id) {

        int to = Integer.parseInt(id);

        ContentEntity content1 = new ContentEntity();
        content1.setId(to);
        content1.setTitle(saveDTO.getTitle());
        content1.setContent(saveDTO.getContent());

        contentRepository.save(content1);
    }
}
