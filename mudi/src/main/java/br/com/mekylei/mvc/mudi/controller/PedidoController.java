package br.com.mekylei.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mekylei.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.mekylei.mvc.mudi.model.Pedido;
import br.com.mekylei.mvc.mudi.model.User;
import br.com.mekylei.mvc.mudi.repository.PedidoRepository;
import br.com.mekylei.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "pedido/formulario";
		}

		String usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getName();
		User usuario = userRepository.findByUsername(usuarioLogado);

		Pedido pedido = requisicao.toPedido();
		pedido.setUser(usuario);
		pedidoRepository.save(pedido);

		return "redirect:/usuario/pedidos";
	}
}
