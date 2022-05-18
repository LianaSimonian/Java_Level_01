package com.aca.classroom.week15.user.service.version5;

import com.aca.classroom.week15.user.service.version5.facade.UniversityFacade;
import com.aca.classroom.week15.user.service.version5.facade.UserAdmissionRequestDto;
import com.aca.classroom.week15.user.service.version5.facade.UserAdmissionResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("universities")
public class UniversityController {

    private final UniversityFacade universityFacade;

    public UniversityController(UniversityFacade universityFacade) {
        this.universityFacade = universityFacade;
    }

    @PostMapping
    public UserAdmissionResponseDto addmit(
            @RequestBody UserAdmissionRequestDto dto) {
        return universityFacade.admit(dto);
    }

    @GetMapping
    public String sayHello() {


        return "Hello";
    }
}