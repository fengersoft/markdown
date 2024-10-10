package com.feng.markdownserver.service;

import com.feng.markdownserver.entity.dto.MarkdownDto;
import com.feng.markdownserver.entity.dto.SearchDto;
import com.feng.markdownserver.entity.vo.MarkdownVo;

import java.util.List;

public interface MarkdownService {
    Integer add(MarkdownDto markdownDto);

    void edit(MarkdownDto markdownDto);

    List<MarkdownVo> showTitles();

    MarkdownVo showInfo(Integer id);

    void deleteInfo(Integer id);

    List<MarkdownVo> search(SearchDto searchDto);
}
