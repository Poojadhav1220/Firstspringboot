package com.example.Firstspringboot.controller;

import com.example.Firstspringboot.Entity.Employee;
import com.example.Firstspringboot.Repositary.EmpRepo;
import com.example.Firstspringboot.helper.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    EmpRepo empRepo;

    @Autowired
    FileUploader uploader;



    @GetMapping("/")
    public String homepage() {

        return "index";
    }

     int maxSize=5;
    @GetMapping("/emp/reg/{curPage}/")
    public String EmpReg(Model model,@PathVariable int curPage)
    {
        Pageable pageable = PageRequest.of(curPage-1, maxSize, Sort.by("id").descending());
        Page<Employee> page = empRepo.findAll(pageable);
        int totalPages = page.getTotalPages();
        List<Employee> listEmp = page.toList();

        model.addAttribute("listEmp", listEmp);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("curPage",curPage);

        return "EmpReg";
    }
    @PostMapping("/emp/save/")
    public String addEmp(Model model, Employee emp, MultipartFile file)
    {
        String fileNameOld = file.getOriginalFilename();

        String extension = fileNameOld.substring(fileNameOld.indexOf(".") + 1);
        emp.setExe(extension);
        Employee empNew = empRepo.save(emp);
        String fileNameNew = empNew.getId() + "." + extension;
        System.out.println("Image New Name is " + fileNameNew);
        uploader.uploadFile(file, fileNameNew);

        Pageable pageable = PageRequest.of(0, maxSize, Sort.by("id").descending());
        Page<Employee> page = empRepo.findAll(pageable);
        int totalPages = page.getTotalPages();
        List<Employee> listEmp = page.toList();

        model.addAttribute("listEmp", listEmp);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("curPage", 1);
        model.addAttribute("msg", "Employee Registration Successful");

        return "empReg";
    }


    @GetMapping("/emp/delete/{empID}/")
    public String deleteEmp(Model model, @PathVariable Long empID)
    {
        empRepo.deleteById(empID);
        List<Employee> employeeList= empRepo.findAll();
        model.addAttribute("employeeList",employeeList);Pageable pageable = PageRequest.of(0,maxSize, Sort.by("id").descending());
        Page<Employee> page = empRepo.findAll(pageable);
        int totalPages = page.getTotalPages();
        List<Employee> listEmp = page.toList();

        model.addAttribute("listEmp", listEmp);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("curPage",1);
        model.addAttribute("msg", "Record deleted successfully");
        return "EmpReg";}
}

