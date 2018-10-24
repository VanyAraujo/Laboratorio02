package ar.edu.utn.frsf.dam.isi.laboratorio02.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frsf.dam.isi.laboratorio02.modelo.Pedido;

public class PedidoRepository {

    private static List<Pedido> LISTA_PEDIDOS = new ArrayList<>();
    private static int GENERADOR_ID_PEDIDO = 0; //esta cosita no funka

    public List<Pedido> getLista(){
        return LISTA_PEDIDOS;
    }

    public void guardarPedido(Pedido p){
        if(p.getId()!=null && p.getId()>0) {
            LISTA_PEDIDOS.remove(p);
        }else{
            int idNuevo = 0;
            for(Pedido pl: LISTA_PEDIDOS){
                if(p.getId() > idNuevo) {
                    idNuevo=p.getId();
                }
            }
            idNuevo++;
            p.setId(idNuevo);
        }
        LISTA_PEDIDOS.add(p);
    }

    public void eliminarPedido(Pedido p){
        if(p.getId()!=null && p.getId()>0) {
            LISTA_PEDIDOS.remove(p);
        }
    }

    public Pedido buscarPorId(Integer id){
        for(Pedido p: LISTA_PEDIDOS){
            if(p.getId().equals(id)) return p;
        }
        return null;
    }




}
