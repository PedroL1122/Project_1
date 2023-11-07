package dao;
import domain.Cliente;

import java.util.*;

public class ClienteMapDAO implements IClienteDAO {
    private Map<Long,Cliente> map;

    public ClienteMapDAO(){
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente){
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }
    @Override
    public void excluir(Long cpf){
        Cliente clienteCadastrado = map.get(cpf);
        map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
    }

    @Override
    public void  alterar(Cliente cliente){
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setNumero(cliente.getNumero());
    }
    @Override
    public Cliente consultar(Long cpf){
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos(){
        return this.map.values();
    }
}
