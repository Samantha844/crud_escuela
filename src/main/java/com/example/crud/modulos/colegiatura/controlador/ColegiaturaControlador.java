package com.example.crud.modulos.colegiatura.controlador;

import com.example.crud.modulos.calificacion.dto.CalificacionDTO;
import com.example.crud.modulos.calificacion.servicio.CalificacionServicio;
import com.example.crud.modulos.colegiatura.dto.ColegiaturaDTO;
import com.example.crud.modulos.colegiatura.servicio.ColegiaturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("colegiatura")

public class ColegiaturaControlador {
    @Autowired
    private ColegiaturaServicio colegiaturaServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<ColegiaturaDTO>> obtenerColegiaturas() {
        List<ColegiaturaDTO> respuesta = colegiaturaServicio.obtenerColegiaturas();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<ColegiaturaDTO> obtenerColegiaturasPorId(@RequestParam Integer id_colegiatura) {
        ColegiaturaDTO respuesta = colegiaturaServicio.obtenerColegiaturasPorId(id_colegiatura);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarColegiatura(@RequestBody ColegiaturaDTO parametros) {
        Boolean respuesta = colegiaturaServicio.guardarColegiatura(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Boolean> actualizarColegiatura(@RequestBody ColegiaturaDTO parametros) {
        Boolean respuesta = colegiaturaServicio.actualizarColegiatura(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarColegiatura(@RequestParam Integer id_colegiatura) {
        Boolean respuesta = colegiaturaServicio.eliminarColegiatura(id_colegiatura);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("activar-inactivar")
    public ResponseEntity<Boolean> activarInactivarColegiatura(@RequestBody Integer id_colegiatura) {
        Boolean respuesta = colegiaturaServicio.activarInactivarColegiatura(id_colegiatura);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
