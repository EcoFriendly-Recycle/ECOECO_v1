package com.recycle.ecoeco.manager.project.controller;

import com.recycle.ecoeco.manager.project.service.ProjectService;
import com.recycle.ecoeco.user.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project_new_list")
    public void findProjectList(){
        System.out.println("project_new_list");
    }
}