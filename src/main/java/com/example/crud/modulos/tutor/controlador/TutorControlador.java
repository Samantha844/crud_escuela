package com.example.crud.modulos.tutor.controlador;

import com.example.crud.modulos.persona.dto.PersonaDTO;
import com.example.crud.modulos.tutor.dto.TutorDTO;
import com.example.crud.modulos.tutor.servicio.TutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutor")
public class TutorControlador {
    @Autowired
    private TutorServicio tutorServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<TutorDTO>> obtenerTutores(){
        List<TutorDTO> respuesta = tutorServicio.obtenerTutor();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<TutorDTO> obtenerTutorPorId(@RequestParam Integer id_tutor){
        TutorDTO respuesta = tutorServicio.obtenerTutorPorId(id_tutor);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarTutor(@RequestBody TutorDTO parametros){
        Boolean respuesta = tutorServicio.guardarTutor(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Boolean> actualizarTutor(@RequestBody TutorDTO parametros){
        Boolean respuesta = tutorServicio.actualizarTutor(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarTutor(@RequestParam Integer id_tutor){
        Boolean respuesta = tutorServicio.eliminarTutor(id_tutor);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @PutMapping("activar-inactivar")
    public ResponseEntity<Boolean> activarInactivarTutor(@RequestBody Integer id_tutor){
        Boolean respuesta = tutorServicio.activarInactivarTutor(id_tutor);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
