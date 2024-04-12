package com.recycle.ecoeco.manager.project.service;

import com.recycle.ecoeco.manager.project.model.dao.ProjectMapper;
import com.recycle.ecoeco.manager.project.model.dto.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectMapper projectMapper;

    public ProjectService(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public List<ProjectDTO> findProjectNewList() {
        return projectMapper.findProjectNewList();
    }

    public List<ProjectDTO> projectDetail(int projectNo) {
        return projectMapper.projectDetail(projectNo);
    }
}
