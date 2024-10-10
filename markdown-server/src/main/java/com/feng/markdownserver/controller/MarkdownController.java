package com.feng.markdownserver.controller;

import com.feng.markdownserver.entity.dto.SearchDto;
import com.feng.markdownserver.entity.vo.MarkdownVo;
import com.feng.markdownserver.entity.RestResult;
import com.feng.markdownserver.entity.dto.MarkdownDto;
import com.feng.markdownserver.service.MarkdownService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/markdown")
public class MarkdownController {

    @Resource
    private MarkdownService markdownService;

    @RequestMapping("/add")
    public RestResult addMarkdown(@RequestBody  MarkdownDto markdownDto) {
        markdownService.add(markdownDto);
        return RestResult.ok(markdownDto);
    }
    @RequestMapping("/edit")
    public RestResult editMarkdown(@RequestBody  MarkdownDto markdownDto) {
        markdownService.edit(markdownDto);
        return RestResult.ok(markdownDto);
    }
    @RequestMapping("/showTitles")
    public RestResult showTitles() {
        List<MarkdownVo> list=markdownService.showTitles();
        return RestResult.ok(list);
    }
    @RequestMapping("/showInfo/{id}")
    public RestResult showInfo(@PathVariable Integer id) {
        MarkdownVo vo=markdownService.showInfo(id);
        return RestResult.ok(vo);
    }
    @RequestMapping("/del/{id}")
    public RestResult deleteInfo(@PathVariable Integer id) {
        markdownService.deleteInfo(id);
        return RestResult.ok();
    }
    @RequestMapping("/search")
    public RestResult search(@RequestBody SearchDto searchDto) {
        List<MarkdownVo> list=markdownService.search(searchDto);
        return RestResult.ok(list);

    }

}
