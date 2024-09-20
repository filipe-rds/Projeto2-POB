package daojpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Veiculo;

public class DAOVeiculo extends DAO<Veiculo>{

    @Override
    public Veiculo read(Object chave) {
        try {
            String placa = (String) chave;
            TypedQuery<Veiculo> query = manager.createQuery("select v from Veiculo v where v.placa = :placa", Veiculo.class);
            query.setParameter("placa", placa);
            Veiculo veiculo = query.getSingleResult();
            return veiculo;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Veiculo> readAll() {
        TypedQuery<Veiculo> query = manager.createQuery("select v from Veiculo", Veiculo.class);
        return query.getResultList();
    }

    // Consulta 1 - Veículos que possuem registros em uma determinada data

    public List<Veiculo> getVeiculosNaData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocalDate = LocalDate.parse(data, formatter);

        // Converte LocalDate para o início e fim do dia
        LocalDateTime inicioDia = dataLocalDate.atStartOfDay();
        LocalDateTime fimDia = dataLocalDate.atTime(23, 59, 59);

        String jpql = "SELECT DISTINCT v FROM Veiculo v JOIN v.registros r WHERE r.datahora BETWEEN :inicio AND :fim";
        TypedQuery<Veiculo> query = manager.createQuery(jpql, Veiculo.class);
        query.setParameter("inicio", inicioDia);
        query.setParameter("fim", fimDia);

        List<Veiculo> listaVeiculos = query.getResultList();

        if (listaVeiculos.isEmpty()) {
            return null;
        }
        return listaVeiculos;
    }

    // Consulta 2 - Veículos que possuem registros acima de uma determinada quantidade

    public List<Veiculo> getVeiculosAcimaDoRegistro(int quantidade) {
        String jpql = "SELECT v FROM Veiculo v WHERE SIZE(v.registros) > :quantidade";
        TypedQuery<Veiculo> query = manager.createQuery(jpql, Veiculo.class);
        query.setParameter("quantidade", quantidade);

        List<Veiculo> listaVeiculos = query.getResultList();

        if (listaVeiculos.isEmpty()) {
            return null;
        }
        return listaVeiculos;
    }



}
