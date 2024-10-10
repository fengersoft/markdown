package com.feng.markdownserver.mapper;


import com.feng.markdownserver.entity.dto.MarkdownDto;
import com.feng.markdownserver.entity.dto.SearchDto;
import com.feng.markdownserver.entity.vo.MarkdownVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarkdownMapper {
    Integer add(MarkdownDto markdownDto);

    void edit(MarkdownDto markdownDto);

    List<MarkdownVo> showTitles();

    MarkdownVo showInfo(@Param("id") Integer id);

    void deleteInfo(@Param("id") Integer id);

    List<MarkdownVo> search(SearchDto searchDto);
}
