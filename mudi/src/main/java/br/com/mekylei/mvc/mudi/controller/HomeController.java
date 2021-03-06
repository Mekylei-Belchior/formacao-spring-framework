package br.com.mekylei.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mekylei.mvc.mudi.model.Pedido;
import br.com.mekylei.mvc.mudi.model.StatusPedido;
import br.com.mekylei.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model) {
		Sort ordenacao = Sort.by("dataDaEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, ordenacao);
		
		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}

}
