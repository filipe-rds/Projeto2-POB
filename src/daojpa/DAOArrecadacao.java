package daojpa;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Arrecadacao;

import java.util.List;

public class DAOArrecadacao extends DAO<Arrecadacao>{

    @Override
    public Arrecadacao read(Object chave) {
        try{
            String data = (String) chave;
            TypedQuery<Arrecadacao> query = manager.createQuery("select a from Arrecadacao a where a.data=:data", Arrecadacao.class);
            query.setParameter("data", data);
            Arrecadacao arrecadacao = query.getSingleResult();
            return arrecadacao;
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public List<Arrecadacao> readAll() {
        TypedQuery<Arrecadacao> query = manager.createQuery("select a from Arrecadacao a", Arrecadacao.class);
        return query.getResultList();
    }

}
