package com.example.crud.modulos.docente.controlador;

import com.example.crud.modulos.colegiatura.dto.ColegiaturaDTO;
import com.example.crud.modulos.docente.dto.DocenteDTO;
import com.example.crud.modulos.docente.servicio.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("docente")
public class DocenteControlador {

    @Autowired
    private DocenteServicio docenteServicio;

    @GetMapping("obtener")
    public ResponseEntity<List<DocenteDTO>> obtenerDocente() {
        List<DocenteDTO> respuesta = docenteServicio.obtenerDocentes();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<DocenteDTO> obtenerDocentesPorId(@RequestParam Integer id_docente) {
        DocenteDTO respuesta = docenteServicio.obtenerDocentesPorId(id_docente);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarDocente(@RequestBody DocenteDTO parametros) {
        Boolean respuesta = docenteServicio.guardarDocente(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Boolean> actualizarDocente(@RequestBody DocenteDTO parametros) {
        Boolean respuesta = docenteServicio.actualizarDocente(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarDocente(@RequestParam Integer id_docente) {
        Boolean respuesta = docenteServicio.eliminarDocente(id_docente);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("activar-inactivar")
    public ResponseEntity<Boolean> activarInactivarDocente(@RequestBody Integer id_docente) {
        Boolean respuesta = docenteServicio.activarInactivarDocente(id_docente);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

}
