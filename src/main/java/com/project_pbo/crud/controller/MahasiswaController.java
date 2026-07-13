package com.project_pbo.crud.controller;

import com.project_pbo.crud.model.Mahasiswa;
import com.project_pbo.crud.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;

    @PostMapping("/post/mahasiswa")
    public Mahasiswa saveMahasiswa(@RequestBody Mahasiswa mahasiswa){
        return mahasiswaService.postMahasiswa(mahasiswa);
    }

    @GetMapping("/get/mahasiswa")
    public List<Mahasiswa>  getMahasiswa(){
        return mahasiswaService.getMahasiswa();
    }

    @GetMapping("/get/mahasiswa/{mahasiswaId}")
    public Mahasiswa getMahasiswa(@PathVariable Integer mahasiswaId){
        return mahasiswaService.getMahasiswa(mahasiswaId);
    }

    @DeleteMapping("/delete/mahasiswa/{mahasiswaId}")
    public ResponseEntity<String> deleteMahasiswa(@PathVariable Integer mahasiswaId){
        try {
            mahasiswaService.deleteMahasiwa(mahasiswaId);
            return ResponseEntity.ok("Delete Success");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
    }

    @PutMapping("/update/mahasiswa")
    public Mahasiswa updateMahasiswa(@RequestBody Mahasiswa mahasiswa){
        return mahasiswaService.updateMahasiswa(mahasiswa);
    }
}
