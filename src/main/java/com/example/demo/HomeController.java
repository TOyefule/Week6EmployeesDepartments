package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

public class HomeController {


    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CloudinaryConfig cloudc;


@RequestMapping("/")
    public String employeeList(Model model){
    model.addAttribute("employee", employeeRepository.findAll());
    return "base";
}

@GetMapping("/addemployee")
    public String courseForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }

@PostMapping("/process")
    public String processForm(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/add";
        }
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @PostMapping("/addpicture")
    public String processForm(@ModelAttribute Employee employee,
                              @RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return "redirect:/add";
        }
        try {
            Map uploadResult= cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            employee.setPhoto(uploadResult.get("url").toString());
            employeeRepository.save(employee);
        } catch (IOException e){
            e.printStackTrace();
            return "redirect:/add";
        }

        return "redirect:/";
    }



    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("course", employeeRepository.findById(id).get());
        return "show";
    }


    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("course", employeeRepository.findById(id).get());
        return "employeeform";
    }


    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        employeeRepository.deleteById(id);
        return "redirect:/";
    }


    @RequestMapping("/department")
    public String departmentList(Model model){
        model.addAttribute("department", employeeRepository.findAll());
        return "departmentList";
    }


    @GetMapping("/adddepartment")
    public String departmentform(Model model) {
        model.addAttribute("department", new Department());
        return "departmentform";
    }


    @PostMapping("/processdepartment")
    public String processForm(@Valid Department department, BindingResult result){
        if (result.hasErrors()){
            return "departmentform";
        }
        departmentRepository.save(department);
        return "redirect:/";
    }






}
