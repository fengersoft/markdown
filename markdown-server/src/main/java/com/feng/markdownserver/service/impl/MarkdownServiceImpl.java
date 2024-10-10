package com.feng.markdownserver.service.impl;

import com.feng.markdownserver.entity.dto.SearchDto;
import com.feng.markdownserver.mapper.MarkdownMapper;
import com.feng.markdownserver.entity.dto.MarkdownDto;
import com.feng.markdownserver.entity.vo.MarkdownVo;
import com.feng.markdownserver.service.MarkdownService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MarkdownServiceImpl implements MarkdownService {

    @Resource
    private MarkdownMapper markdownMapper;

    @Override
    public Integer add(MarkdownDto markdownDto) {
           return markdownMapper.add(markdownDto);
    }

    @Override
    public void edit(MarkdownDto markdownDto) {
        markdownMapper.edit(markdownDto);
    }

    @Override
    public List<MarkdownVo> showTitles() {
        return markdownMapper.showTitles();
    }

    @Override
    public MarkdownVo showInfo(Integer id) {
        return markdownMapper.showInfo(id);
    }

    @Override
    public void  deleteInfo(Integer id) {
        markdownMapper.deleteInfo(id);
    }

    @Override
    public List<MarkdownVo> search(SearchDto searchDto) {
        return markdownMapper.search(searchDto);
    }
}
