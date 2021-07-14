package br.com.mekylei.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.mekylei.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {

	private static final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Integer pedidoId;
	
	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	private String valorOfertado;
	
	@NotNull
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	private String dataEntrega;
	private String comentario;

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValorOfertado() {
		return valorOfertado;
	}

	public void setValorOfertado(String valorOfertado) {
		this.valorOfertado = valorOfertado;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setId(this.pedidoId);
		oferta.setValorOferta(new BigDecimal(this.valorOfertado));
		oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, formatador));
		oferta.setComentario(this.comentario);

		return oferta;
	}

}
