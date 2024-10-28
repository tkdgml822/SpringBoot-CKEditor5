package com.example.demo.service;

import com.example.demo.dto.SaveDTO;
import com.example.demo.entity.ContentEntity;
import com.example.demo.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    // Service - Repository 연결
    @Autowired
    public ContentService(ContentRepository contentRepository) {

        this.contentRepository = contentRepository;
    }

    public void saveContent(SaveDTO saveDTO) {
        String title = saveDTO.getTitle();
        String content = saveDTO.getContent();

        ContentEntity content1 = new ContentEntity();

        // set을 사용하면 안됨 - 추후 변경 (생성자 방식을 사용해야 한다.)
        content1.setTitle(title);
        content1.setContent(content);

        contentRepository.save(content1);
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
