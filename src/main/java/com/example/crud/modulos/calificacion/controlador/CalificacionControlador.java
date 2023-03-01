package com.example.crud.modulos.calificacion.controlador;

import com.example.crud.modulos.calificacion.dto.CalificacionDTO;
import com.example.crud.modulos.calificacion.servicio.CalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("calificacion")
public class CalificacionControlador {
    @Autowired
    private CalificacionServicio calificacionServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<CalificacionDTO>> obtenerCalificaciones() {
        List<CalificacionDTO> respuesta = calificacionServicio.obtenerCalificaciones();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<CalificacionDTO> obtenerCalificacionPorId(@RequestParam Integer idCalificacion) {
        CalificacionDTO respuesta = calificacionServicio.obtenerCalificacionesPorId(idCalificacion);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarAlumno(@RequestBody CalificacionDTO parametros) {
        Boolean respuesta = calificacionServicio.guardarCalificacion(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Boolean> actualizarCalificacion(@RequestBody CalificacionDTO parametros) {
        Boolean respuesta = calificacionServicio.actualizarCalificacion(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarCalificacion(@RequestParam Integer idCalificacion) {
        Boolean respuesta = calificacionServicio.eliminarCalificacion(idCalificacion);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("activar-inactivar")
    public ResponseEntity<Boolean> activarInactivarCalificacion(@RequestBody Integer idCalificacion) {
        Boolean respuesta = calificacionServicio.activarInactivarCalificacion(idCalificacion);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
