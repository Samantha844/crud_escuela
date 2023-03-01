package com.example.crud.modulos.alumno.controlador;

import com.example.crud.modulos.alumno.dto.AlumnoDTO;
import com.example.crud.modulos.alumno.servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alumno")
public class AlumnoControlador {
    @Autowired
    private AlumnoServicio alumnoServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<AlumnoDTO>> obtenerAlumnos(){
        List<AlumnoDTO> respuesta = alumnoServicio.obtenerAlumno();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<AlumnoDTO> obtenerAlumnos(@RequestParam Integer id_alumno){
        AlumnoDTO respuesta = alumnoServicio.obtenerAlumnoPorId(id_alumno);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarAlumno(@RequestBody AlumnoDTO parametros){
        Boolean respuesta = alumnoServicio.guardarAlumno(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Boolean> actualizarAlumno(@RequestBody AlumnoDTO parametros){
        Boolean respuesta = alumnoServicio.actualizarAlumno(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarAlumno(@RequestParam Integer id_alumno){
        Boolean respuesta = alumnoServicio.eliminarAlumno(id_alumno);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @PutMapping("activar-inactivar")
    public ResponseEntity<Boolean> activarInactivarAlumno(@RequestBody Integer id_alumno){
        Boolean respuesta = alumnoServicio.activarInactivarAlumno(id_alumno);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

}

