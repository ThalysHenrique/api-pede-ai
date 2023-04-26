package com.api.pedeai.schedule;

import com.api.pedeai.models.Pedido;
import com.api.pedeai.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleConfig {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Scheduled(fixedDelay = 10000)
    public void atualizaPedidoCriado() throws InterruptedException {

        List<Pedido> pedidosNulos = pedidoRepository.findByStatus(null);

        for(Pedido p : pedidosNulos){
            p.setStatus("Pedido Criado");
            pedidoRepository.save(p);
        }


        List<Pedido> pedidosCriados = pedidoRepository.findByStatus("Pedido Criado");

        for(Pedido p : pedidosCriados){
            p.setStatus("Pedido em Separação");
            pedidoRepository.save(p);
        }

        Thread.sleep(3000);

        List<Pedido> pedidosEmSeparacao = pedidoRepository.findByStatus("Pedido em Separação");

        for(Pedido p : pedidosEmSeparacao){
            p.setStatus("Pedido em Rota de Entrega");
            pedidoRepository.save(p);
        }


    }
}
