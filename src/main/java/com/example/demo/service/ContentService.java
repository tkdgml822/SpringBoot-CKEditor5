package com.example.demo.service;

import com.example.demo.dto.SaveDTO;
import com.example.demo.entity.ContentEntity;
import com.example.demo.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    private ContentRepository contentRepository;

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
}
