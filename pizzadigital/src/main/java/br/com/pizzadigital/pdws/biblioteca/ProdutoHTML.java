package br.com.pizzadigital.pdws.biblioteca;

import java.util.List;

import br.com.pizzadigital.pdws.model.Produto;
import br.com.pizzadigital.pdws.service.ProdutoService;

public class ProdutoHTML {

	//--------------------------------------------
	public static String listagemProdutos(ProdutoService produtoService) {
		
		String retorno = new String();

		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<style>");
		sb.append("table {");
		sb.append("    border-collapse: collapse;");
		sb.append("    width: 100%;");
		sb.append("}");
		
		sb.append("th, td {");
		sb.append("    text-align: left;");
		sb.append("    padding: 8px;");
		sb.append("}");
		
		sb.append("tr:nth-child(even){background-color: #f2f2f2}");
		sb.append("</style>");
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td colspan=4><font face=verdana size=3><b>");
		sb.append("Catálogo Completo de Pizzas");
		sb.append("</b></font></td>");
		sb.append("</tr>");
		
		List<Produto> produtos = produtoService.all();
		
		sb.append("<tr>");
	
		sb.append("<td><font face=verdana size=2>");
		sb.append("Imagem");
		sb.append("</font></td>");
		
		sb.append("<td><font face=verdana size=2>");
		sb.append("Título");
		sb.append("</font></td>");
		
		sb.append("<td><font face=verdana size=2>");
		sb.append("Preço 4 fatias");
		sb.append("</font></td>");
		
		sb.append("<td><font face=verdana size=2>");
		sb.append("Preço 6 fatias");
		sb.append("</font></td>");
		
		sb.append("<td><font face=verdana size=2>");
		sb.append("Preço 8 fatias");
		sb.append("</font></td>");
		
		sb.append("</tr>");

		for(Produto produto : produtos) {
			
			sb.append("<tr>");
			
			sb.append("<td><font face=verdana size=2>");
			sb.append("<img src=\"data:image/png;base64," + produto.getB64_imagem() + "\" alt=\"" + produto.getReceita() + "\" style=\"height:25%;width:25%\"/>");
			sb.append("</font></td>");
			
			sb.append("<td><font face=verdana size=2>");
			sb.append("<b>" + produto.getCodigo() + "</b><br><br>" + produto.getTitulo());
			sb.append("</font></td>");
			
			sb.append("<td><font face=verdana size=2>");
			sb.append(Biblioteca.formatarValor(produto.getPequena()));
			sb.append("</font></td>");
			
			sb.append("<td><font face=verdana size=2>");
			sb.append(Biblioteca.formatarValor(produto.getMedia()));
			sb.append("</font></td>");
			
			sb.append("<td><font face=verdana size=2>");
			sb.append(Biblioteca.formatarValor(produto.getGrande()));
			sb.append("</font></td>");
						
			sb.append("</tr>");
		}
		
		sb.append("</table>");
		
		sb.append("</body></html>");

		retorno = sb.toString();
		
		return retorno;
		
	}
	//--------------------------------------------
	public static String welcome() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body><center>");
		sb.append("<br><br><br>");
		
		sb.append("<hr>");
		sb.append("<br><br>");
		
		sb.append("<font face=verdana size=5 color=#FF5722>");
		sb.append("RESTful Web Service: Java + Spark + Mongo");
		sb.append("<br><br>");
		sb.append("+-+-+-+-+-+ API Pizza Digital™ +-+-+-+-+-+ ");
		sb.append("</b></font>");
		
		sb.append("<br><br>");
		
		sb.append("<font face=verdana size=3>");
		sb.append(new java.util.Date().toString());
		sb.append("</b></font>");
		
		sb.append("<br><br><hr><br><br>");
		
		sb.append("<font face=verdana size=5>");
		sb.append("<b>Comandos:</b>");
		sb.append("<br><br>");
		
		sb.append("<font face=verdana size=2>");
		sb.append("/produtos -> Cardápio em formato JSON com imagem Base64.");
		sb.append("<br><br>");
		sb.append("<font face=verdana size=2>");
		sb.append("/catalogo -> Apresentação do cardápio com visual mais WEB.");
		sb.append("<br><br>");
		sb.append("<font face=verdana size=2>");
		sb.append("/consumidores -> Listagem de todos os clientes em formato JSON.");
		sb.append("<br><br>");
		sb.append("<font face=verdana size=2>");
		sb.append("/pedidos -> Listagem de todos os pedidos em formato JSON.");
		sb.append("<br><br>");
		
		sb.append("<hr>");
		
		sb.append("</center></body></html>");
				
		return sb.toString();		
	}
	//--------------------------------------------
}