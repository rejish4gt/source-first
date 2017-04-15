package com.deccanherald.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deccanherald.entity.IssueReport;
import com.deccanherald.entity.SourceFirstCode;
import com.deccanherald.repository.IssueReportRepository;
import com.deccanherald.repository.SourceFirstCodeRepository;

@Controller
public class ViewController {

	@Autowired
	SourceFirstCodeRepository sourceFirstCodeRepository;
	
	@Autowired
	IssueReportRepository issueReportRepository;
	
	@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
		List<SourceFirstCode> codes = sourceFirstCodeRepository.findAll();
        model.addAttribute("categories", codes);
        return "new-report";
    }
	
	@RequestMapping("/reportIssue")
	public String reportIssue(@ModelAttribute("issue") IssueReport issueReport, Model model){
		List<IssueReport> reports = issueReportRepository.findAll();
		model.addAttribute("reports", reports);
        return "my-reports";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("issue") IssueReport issueReport, Model model){
		List<IssueReport> reports = issueReportRepository.findAll();
		model.addAttribute("reports", reports!=null?reports.size():0);
        return "dashboard";
	}
	
	@RequestMapping("/filtered")
	public String filtered(@ModelAttribute("issue") IssueReport issueReport, Model model){
		List<IssueReport> reports = issueReportRepository.findAll();
		model.addAttribute("reports", reports);
        return "filtered";
	}
	
	@RequestMapping("/filteredEducation")
	public String filteredEducation(@ModelAttribute("issue") IssueReport issueReport, Model model){
		List<IssueReport> reports = issueReportRepository.findAll();
		model.addAttribute("reports", reports);
        return "education-filtered";
	}
}
