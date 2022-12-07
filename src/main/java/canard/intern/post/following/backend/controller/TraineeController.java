package canard.intern.post.following.backend.controller;


import canard.intern.post.following.backend.enums.Gender;
import dto.TraineeDto;
import lombok.Data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/trainees")
public class TraineeController {

    @GetMapping
    public List<TraineeDto> getAll (){
        return List.of(
                TraineeDto.builder().id(1).lastName("Bond").firstName("James").gender(Gender.M).birthDate(LocalDate.of(1992,8,30) ).build(),
                TraineeDto.builder().id(2).lastName("Aubert").firstName("Jean-Luc").gender(Gender.M).build(),
                TraineeDto.builder().id(3).lastName("Neymar").firstName("Jean").gender(Gender.X).build(),
                TraineeDto.builder().id(4).lastName("Moneypenny").firstName("Miss").gender(Gender.F).build()
        );
    }

    @GetMapping("/{id}")
    public TraineeDto getById(@PathVariable("id")int id){
        return TraineeDto.builder().id(id).lastName("Moneypenny").firstName("Miss").gender(Gender.F).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeDto create(@Valid @RequestBody TraineeDto traineeDto ){
        traineeDto.setId(10);
        return traineeDto;
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteById(@PathVariable("id")int id){

    }

    @PutMapping("/{id}")
    public TraineeDto putById(@PathVariable("id")int id, @Valid @RequestBody TraineeDto traineeDto ){
        if (Objects.nonNull(traineeDto.getId()) && (traineeDto.getId() !=id)){
            throw new IllegalArgumentException();
        }
        return  traineeDto;
    }
}

