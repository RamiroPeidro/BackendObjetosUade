package service;

import Daos.PeticionDAO;
import Daos.PacienteDAO;
import Daos.SucursalDAO;
import Daos.PracticaDAO;
import Dtos.PeticionDTO;
import Dtos.ResultadoDTO;
import Dtos.PacienteDTO;
import model.Peticion;
import model.Practica;
import model.Paciente;
import model.Resultado;
import model.Sucursal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PeticionService {
    private ResultadoService resultadoService;
    private PeticionDAO peticionDAO;
    private PacienteDAO pacienteDAO;
    private SucursalDAO sucursalDAO;
    private PracticaDAO practicaDAO;

    public PeticionService() {
        this.peticionDAO = new PeticionDAO();
        this.resultadoService = new ResultadoService();
        this.pacienteDAO = new PacienteDAO();
        this.sucursalDAO = new SucursalDAO();
        this.practicaDAO = new PracticaDAO();
    }

    public void cargarPeticion(int Dni, String obraSocial, int sucursalId) {
        Paciente paciente = pacienteDAO.findById(Dni);
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }

        Sucursal sucursal = sucursalDAO.findById(sucursalId);
        if (sucursal == null) {
            throw new IllegalArgumentException("Sucursal no encontrada");
        }

        Peticion nuevaPeticion = new Peticion(
                generarNuevoId(),
                paciente,
                obraSocial,
                new Date(),
                new Date(Long.MAX_VALUE),
                sucursal,
                new ArrayList<>(),
                new ArrayList<>()
        );

        peticionDAO.create(nuevaPeticion);
    }

    public void asociarPracticaAPeticion(int idPeticion, int practicaId) {
        Peticion peticion = peticionDAO.findById(idPeticion);
        if (peticion == null) {
            throw new IllegalArgumentException("Peticion no encontrada");
        }

        Practica practica = practicaDAO.findById(practicaId);
        if (practica == null) {
            throw new IllegalArgumentException("Practica no encontrada");
        }

        peticion.getListaPracticas().add(practica);
        Resultado nuevoResultado = new Resultado(0, practica, peticion);
        peticion.getListaResultados().add(nuevoResultado);

        // Calcular la nueva fechaCalculadaDeEntrega
        Date nuevaFechaCalculadaDeEntrega = calcularFechaEntrega(peticion, practica);
        peticion.setFechaCalculadaDeEntrega(nuevaFechaCalculadaDeEntrega);

        peticionDAO.update(peticion);
    }


    private int generarNuevoId() {
        return peticionDAO.getLastInsertId() + 1;
    }


    private Date calcularFechaEntrega(Peticion peticion, Practica nuevaPractica) {
        // Inicialmente, establecemos la fechaCalculadaDeEntrega como la fechaCarga más las cantHorasResultados de la nueva práctica
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(peticion.getFechaCarga());
        calendar.add(Calendar.HOUR_OF_DAY, nuevaPractica.getCantHorasResultados().intValue());
        Date nuevaFechaEntrega = calendar.getTime();

        // Comparamos con las fechas de entrega calculadas previamente y establecemos la más lejana
        for (Practica practica : peticion.getListaPracticas()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(peticion.getFechaCarga());
            cal.add(Calendar.HOUR_OF_DAY, practica.getCantHorasResultados().intValue());
            Date fechaEntrega = cal.getTime();
            if (fechaEntrega.after(nuevaFechaEntrega)) {
                nuevaFechaEntrega = fechaEntrega;
            }
        }

        return nuevaFechaEntrega;
    }

    public void cargarResultadoEnPractica(int idPeticion, int idPractica, float valor) {
        Peticion peticion = peticionDAO.findById(idPeticion);
        if (peticion == null) {
            throw new IllegalArgumentException("Peticion no encontrada");
        }

        Practica practica = obtenerPracticaPorId(peticion, idPractica);
        if (practica == null) {
            throw new IllegalArgumentException("Practica no encontrada en la peticion");
        }

        Resultado resultado = obtenerResultadoPorPractica(peticion, practica);
        if (resultado == null) {
            throw new IllegalArgumentException("Resultado no encontrado para la práctica en la petición");
        }

        resultado.setValor(valor);
        resultado.setFinalizado(true);

        peticion.setPeticionFinalizada(peticion.chequearSiLaPeticionEstaFinalizada());

        peticionDAO.update(peticion);
    }

    public void modificarResultadoDePractica(int idPeticion, int idPractica, float nuevoValor, boolean finalizado) {
        Peticion peticion = peticionDAO.findById(idPeticion);
        if (peticion == null) {
            throw new IllegalArgumentException("Peticion no encontrada");
        }

        Practica practica = obtenerPracticaPorId(peticion, idPractica);
        if (practica == null) {
            throw new IllegalArgumentException("Practica no encontrada en la peticion");
        }

        Resultado resultado = obtenerResultadoPorPractica(peticion, practica);
        if (resultado == null) {
            throw new IllegalArgumentException("Resultado no encontrado para la práctica en la petición");
        }

        resultado.setValor(nuevoValor);
        resultado.setFinalizado(finalizado);

        peticion.setPeticionFinalizada(peticion.chequearSiLaPeticionEstaFinalizada());

        peticionDAO.update(peticion);
    }


    private Practica obtenerPracticaPorId(Peticion peticion, int practicaId) {
        for (Practica practica : peticion.getListaPracticas()) {
            if (practica.getCodigoPractica() == practicaId) {
                return practica;
            }
        }
        return null;
    }

    private Resultado obtenerResultadoPorPractica(Peticion peticion, Practica practica) {
        for (Resultado resultado : peticion.getListaResultados()) {
            if (resultado.getPractica().equals(practica)) {
                return resultado;
            }
        }
        return null;
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
            peticionDAO.update(peticion);
        } else {
            throw new IllegalArgumentException("Peticion no encontrada");
        }
    }

    public List<ResultadoDTO> solicitarResultado(int idPeticion) {
        Peticion peticion = peticionDAO.findById(idPeticion);
        if (peticion == null) {
            throw new IllegalArgumentException("Peticion no encontrada");
        }

        List<Resultado> resultados = peticion.getListaResultados();
        List<ResultadoDTO> resultadoDTOs = new ArrayList<>();

        for (Resultado resultado : resultados) {
            int practicaId = resultado.getPractica().getCodigoPractica();
            String valor;

            //TODO retirar por sucursal refiere solo a reservado y no a critico?
            if (resultado.isValorReservado()) {
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

    public void eliminarResultadoDePractica(int idPeticion, int idPractica) {
        Peticion peticion = peticionDAO.findById(idPeticion);
        if (peticion == null) {
            throw new IllegalArgumentException("Peticion no encontrada");
        }

        Practica practica = obtenerPracticaPorId(peticion, idPractica);
        if (practica == null) {
            throw new IllegalArgumentException("Practica no encontrada en la peticion");
        }

        Resultado resultado = obtenerResultadoPorPractica(peticion, practica);
        if (resultado == null) {
            throw new IllegalArgumentException("Resultado no encontrado para la práctica en la petición");
        }

        peticion.getListaResultados().remove(resultado);
        peticion.setPeticionFinalizada(peticion.chequearSiLaPeticionEstaFinalizada());

        peticionDAO.update(peticion);
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
