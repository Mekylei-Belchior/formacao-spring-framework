package br.com.mekylei.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mekylei.mvc.mudi.model.Pedido;
import br.com.mekylei.mvc.mudi.model.StatusPedido;
import br.com.mekylei.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	PedidoRepository pedidoRepository;

	@GetMapping("pedidos")
	public String home(Model model, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		model.addAttribute("pedidos", pedidos);

		return "usuario/pedidos";
	}

	@GetMapping("pedidos/{status}")
	public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {
		List<Pedido> pedidos = 
				pedidoRepository.findByUsuarioEStatusPedido(
						StatusPedido.valueOf(status.toUpperCase()),	principal.getName()
						);
		
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);

		return "usuario/pedidos";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/pedidos";
	}

}
