package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.PublisherDto;
import com.example.Library.Management.System.model.Publisher;
import com.example.Library.Management.System.service.PublisherService;
import com.example.Library.Management.System.service.mapper.PublisherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("publisher")
public class PublisherController {
    private final PublisherService publisherService;
    private final PublisherMapper publisherMapper;

    @GetMapping
    public String index(Model model) {
        List<Publisher> publisherList = this.publisherService.getAllPublisher();
        model.addAttribute("publisherList", this.publisherMapper.toDtoWithAllEntityList(publisherList));
        return "publisher-list";
    }


    @GetMapping("/register")
    public String createPublisherPage() {
        return "publisher-registration";
    }

    @PostMapping("/register")
    public String createPublisher(@ModelAttribute PublisherDto dto) {
        Publisher publisher = publisherMapper.toEntity(dto);
        this.publisherService.createPublisher(publisher);
        return "redirect:/publisher";
    }

    @GetMapping("/update/{id}")
    public String updatePublisherPage(@PathVariable Long id, Model model) {
        Publisher publisher = this.publisherService.findById(id);
        model.addAttribute("publisher", this.publisherMapper.toDto(publisher));
        return "publisher-update";
    }

    @PostMapping("/update/*")
    public String updatePublisher(@ModelAttribute("publisher") PublisherDto dto) {
        Publisher publisher = publisherMapper.toEntity(dto);
        publisher.setId(dto.getPublisherId());
        this.publisherService.createPublisher(publisher);
        return "redirect:/publisher";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        Publisher publisher = this.publisherService.findById(id);
        this.publisherService.deleteById(id);
        return "redirect:/publisher";
    }
}
