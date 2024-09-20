package daojpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Registro;

public class DAORegistro extends DAO<Registro>{

    @Override
    public Registro read(Object chave) {
        try{
            int id = (int) chave;
            TypedQuery<Registro> query = manager.createQuery("select r from Registro r where r.id=:id", Registro.class);
            query.setParameter("id", id);
            Registro registro = query.getSingleResult();
            return registro;
        } catch (NoResultException e){
            return null;
        }

    }

    @Override
    public List<Registro> readAll() {
        TypedQuery<Registro> query = manager.createQuery("select r from Registro r", Registro.class);
        return query.getResultList();

    }

    // Consulta 1 - Registros em uma determinada data

    public List<Registro> registrosNaData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocalDate = LocalDate.parse(data, formatter);
        
        // Converte LocalDate para um formato compatível com o banco (assumindo que getDatahora é LocalDateTime)
        LocalDateTime inicioDia = dataLocalDate.atStartOfDay();
        LocalDateTime fimDia = dataLocalDate.atTime(23, 59, 59);
        
        String jpql = "SELECT r FROM Registro r WHERE r.datahora BETWEEN :inicio AND :fim";
        TypedQuery<Registro> query = manager.createQuery(jpql, Registro.class);
        query.setParameter("inicio", inicioDia);
        query.setParameter("fim", fimDia);
        
        List<Registro> listaRegistros = query.getResultList();
        
        if (listaRegistros.isEmpty()) {
            return null;
        }
        return listaRegistros;
    }

}
