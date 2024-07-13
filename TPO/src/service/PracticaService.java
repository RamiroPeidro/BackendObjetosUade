package service;

import Daos.PracticaDAO;
import Dtos.PracticaDTO;
import Dtos.RangoValorDTO;
import model.Practica;
import model.RangoValor;

public class PracticaService {

    private PracticaDAO practicaDAO;

    public PracticaService() {
        this.practicaDAO = new PracticaDAO();
    }

    public void darAltaPractica(PracticaDTO practicaDTO) {
        Practica practica = convertirDTOaPractica(practicaDTO);
        practicaDAO.create(practica);
    }

    public void darBajaPractica(int codigoPractica) {
        Practica practica = practicaDAO.findById(codigoPractica);
        if (practica != null) {
            practicaDAO.delete(practica);
        } else {
            throw new IllegalArgumentException("Practica no encontrada");
        }
    }

    public void modificarPractica(PracticaDTO practicaDTO) {
        Practica practicaExistente = practicaDAO.findById(practicaDTO.getCodigoPractica());
        if (practicaExistente != null) {
            Practica practicaModificada = convertirDTOaPractica(practicaDTO);
            practicaDAO.update(practicaModificada);
        } else {
            throw new IllegalArgumentException("Practica no encontrada");
        }
    }

    private Practica convertirDTOaPractica(PracticaDTO practicaDTO) {
        RangoValor rangoValores = convertirDTORangoValorAEntidad(practicaDTO.getRangoValores());
        return new Practica(
                practicaDTO.getCodigoPractica(),
                practicaDTO.getNombrePractica(),
                practicaDTO.getGrupo(),
                rangoValores,
                practicaDTO.getCantHorasResultados(),
                practicaDTO.getHabilitada(),
                practicaDTO.getEsReservada()
        );
    }

    private RangoValor convertirDTORangoValorAEntidad(RangoValorDTO rangoValorDTO) {
        return new RangoValor(rangoValorDTO.getMinValor(), rangoValorDTO.getMaxValor());
    }

    private RangoValorDTO convertirEntidadARangoValorDTO(RangoValor rangoValor) {
        return new RangoValorDTO(rangoValor.getMinValor(), rangoValor.getMaxValor());
    }

    public PracticaDTO convertirPracticaADTO(Practica practica) {
        RangoValorDTO rangoValorDTO = convertirEntidadARangoValorDTO(practica.getRangoValores());
        return new PracticaDTO(
                practica.getCodigoPractica(),
                practica.getNombrePractica(),
                practica.getGrupo(),
                rangoValorDTO,
                practica.getCantHorasResultados(),
                practica.getHabilitada(),
                practica.getEsReservada()
        );
    }
}
