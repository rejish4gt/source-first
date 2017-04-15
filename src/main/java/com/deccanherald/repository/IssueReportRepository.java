package com.deccanherald.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.deccanherald.entity.IssueReport;

@RepositoryRestResource
public interface IssueReportRepository extends JpaRepository<IssueReport, UUID> {

}
