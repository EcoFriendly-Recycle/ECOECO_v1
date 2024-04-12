package com.recycle.ecoeco.manager.project.model.dao;

import com.recycle.ecoeco.manager.project.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<ProjectDTO> findProjectNewList();

    List<ProjectDTO> projectDetail(int projectNo);
}
