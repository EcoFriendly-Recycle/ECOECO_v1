package com.recycle.ecoeco.manager.project.controller;

import com.recycle.ecoeco.manager.project.model.dto.ProjectDTO;
import com.recycle.ecoeco.manager.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manager/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project_new_list")
    public String findProjectNewList(Model model){
        System.out.println("project_new_list");

        List<ProjectDTO> projectNewList = projectService.findProjectNewList();

        model.addAttribute("projectNewList", projectNewList);

        return "/manager/project/project_new_list";

    }

    @GetMapping("/project_now_list")
    public String findProjectNowList(Model model) {
        System.out.println("project_now_list");
        return "/manager/project/project_now_list";
    }

    @GetMapping("/project_end_list")
    public String findProjectEndList(Model model) {
        System.out.println("project_end_list");
        return "/manager/project/project_end_list";
    }

    @GetMapping("/project_return_list")
    public String findProjectReturnList(Model model) {
        System.out.println("project_return_list");
        return "/manager/project/project_return_list";
    }

    @GetMapping("/project_detail")
    public String projectDetail(@RequestParam int projectNo, Model model) {
        System.out.println("project_detail");
        System.out.println("projectNo : " + projectNo);

        List<ProjectDTO> projectDetail = projectService.projectDetail(projectNo);
        model.addAttribute("projectDetail", projectDetail);
        model.addAttribute("projectNo", projectNo);



        return "/manager/project/project_detail";
    }

    @GetMapping("/project_modify")
    public void projectModifypage(Model model) {
        System.out.println("project_modify");
//        return "/manager/project/project_modify";
    }

    @GetMapping("/project_news")
    public String projectNews(Model model) {
        System.out.println("project_news");
        return "/manager/project/project_news";
    }

    @GetMapping("/project_review")
    public String projectReview(Model model) {
        System.out.println("project_review");
        return "/manager/project/project_review";
    }


}