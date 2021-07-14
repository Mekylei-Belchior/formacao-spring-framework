package br.com.mekylei.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mekylei.mvc.mudi.model.Pedido;
import br.com.mekylei.mvc.mudi.model.StatusPedido;
import br.com.mekylei.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("aguardando")
	public List<Pedido> getPedidoAguardandoOferta() {
		Sort ordenacao = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, ordenacao);

		return pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO, paginacao);

	}

}
