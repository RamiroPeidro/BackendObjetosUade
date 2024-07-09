package service;

import Daos.PeticionDAO;
import Dtos.PeticionDTO;
import Dtos.ResultadoDTO;
import model.Peticion;
import model.Practica;
import model.Resultado;

import java.util.ArrayList;
import java.util.List;

public class PeticionService {

    private PeticionDAO peticionDAO;

    public PeticionService() {
        this.peticionDAO = new PeticionDAO();
    }

    public void darBajaPeticion(int numeroPeticion) {
        Peticion peticion = peticionDAO.findById(numeroPeticion);
        if (peticion != null) {
            peticionDAO.delete(peticion);
        } else {
            throw new IllegalArgumentException("Peticion no encontrada");
        }
    }

    public void modificarPeticion(int numeroPeticion) {
        Peticion peticion = peticionDAO.findById(numeroPeticion);
        if (peticion != null) {
            // Implementar lógica de modificación si es necesario
            peticionDAO.update(peticion);
        } else {
            throw new IllegalArgumentException("Peticion no encontrada");
        }
    }

    public List<ResultadoDTO> solicitarResultados(int idPeticion) {
        return consultarResultado(idPeticion);
    }

    private List<ResultadoDTO> consultarResultado(int idPeticion) {
        Peticion peticion = peticionDAO.findById(idPeticion);
        if (peticion == null) {
            throw new IllegalArgumentException("Peticion no encontrada");
        }

        List<Resultado> resultados = peticion.getListaResultados();
        List<ResultadoDTO> resultadoDTOs = new ArrayList<>();

        for (Resultado resultado : resultados) {
            int practicaId = resultado.getPractica().getCodigoPractica();
            String valor;

            if (resultado.isValorReservado() || resultado.isValorCritico()) {
                valor = "Retirar por sucursal";
            } else {
                valor = String.valueOf(resultado.getValor());
            }

            ResultadoDTO resultadoDTO = new ResultadoDTO(
                    valor,
                    practicaId,
                    resultado.isValorCritico(),
                    resultado.isValorReservado()
            );

            resultadoDTOs.add(resultadoDTO);
        }

        return resultadoDTOs;
    }

    public List<PeticionDTO> listarPeticionesCriticas() {
        List<Peticion> peticiones = peticionDAO.findAll();
        List<PeticionDTO> peticionesCriticasDTO = new ArrayList<>();

        for (Peticion peticion : peticiones) {
            if (peticion.chequearSiTieneResultadosCriticos()) {
                peticionesCriticasDTO.add(convertirPeticionADTO(peticion));
            }
        }

        return peticionesCriticasDTO;
    }

    private PeticionDTO convertirPeticionADTO(Peticion peticion) {
        PeticionDTO peticionDTO = new PeticionDTO();
        peticionDTO.setIdPeticion(peticion.getIdPeticion());
        peticionDTO.setPacienteId(peticion.getPaciente().getDNIPaciente());
        peticionDTO.setObraSocial(peticion.getObraSocial());
        peticionDTO.setFechaCarga(peticion.getFechaCarga());
        peticionDTO.setPracticaAsociadaId(peticion.getPracticaAsociada().getCodigoPractica());
        peticionDTO.setFechaCalculadaDeEntrega(peticion.getFechaCalculadaDeEntrega());
        peticionDTO.setSucursalId(peticion.getSucursal().getNumero());

        List<Integer> listaPracticasIds = new ArrayList<>();
        for (Practica practica : peticion.getListaPracticas()) {
            listaPracticasIds.add(practica.getCodigoPractica());
        }
        peticionDTO.setListaPracticasIds(listaPracticasIds);

        List<ResultadoDTO> listaResultados = new ArrayList<>();
        for (Resultado resultado : peticion.getListaResultados()) {
            int practicaId = resultado.getPractica().getCodigoPractica();
            String valor;

            if (resultado.isValorReservado() || resultado.isValorCritico()) {
                valor = "Retirar por sucursal";
            } else {
                valor = String.valueOf(resultado.getValor());
            }

            ResultadoDTO resultadoDTO = new ResultadoDTO(
                    valor,
                    practicaId,
                    resultado.isValorCritico(),
                    resultado.isValorReservado()
            );

            listaResultados.add(resultadoDTO);
        }
        peticionDTO.setListaResultados(listaResultados);

        return peticionDTO;
    }
}
