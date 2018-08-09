/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.alimentos;

import br.com.entra21java.bean.AlimentoBean;
import br.com.entra21java.dao.AlimentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet(urlPatterns = "/alimentos")
public class AlimentoIndex extends HttpServlet {

    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        List<AlimentoBean> alimentos = new AlimentoDAO().obterTodos();
        out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alimentos - Lista</title>");
        out.println("<link rel='stylesheet' type='text/css' href='bootstrap/css/bootstrap.css'/>");
        out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/all.css' "
                + "integrity='sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ' "
                + "crossorigin='anonymous'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container-fluid'>");
        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");

        out.println("<h3 class='text-center'>Lista de Alimentos</h3>");
        out.println("</div>");
        out.println("</div>");

        out.println("<div class='row'>");
        out.println("<div class='col-md-2 offset-md-10'>");
        out.println("<a href='/WebExemplo02/alimentos/cadastro' "
                + "class='btn btn-primary float-right'><i class='fa fa-user'></i> Novo Alimento</a>");
        out.println("</div>");
        out.println("</div>");

        gerarTabela(alimentos);

        out.println("</body>");
        out.println("</html>");
    }

    private void gerarTabela(List<AlimentoBean> alimentos) {
        out.println("<div class='row mtx-3 justify-content-md-center'>");
        out.println("<div class='col-md-8'>");

        out.println("<table class='table table-striped table-hover'>");
        out.println("<thead>");
        out.println("<tr class='table-primary'>");
        out.println("<th>Código</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Quantidade</th>");
        out.println("<th>Preço</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (AlimentoBean alimento : alimentos) {

            out.println("<tr>");
            out.println("<td>" + alimento.getId() + "</td>");
            out.println("<td>" + alimento.getNome() + "</td>");
            out.println("<td>" + alimento.getQuantidade() + "</td>");
            out.println("<td>" + alimento.getPreco() + "</td>");
            out.println("<td>");

            out.println("<a href='/WebExemplo02/alimentos/editar?id="
                    + alimento.getId() + "'class='btn btn-outline-success'><i class='fa fa-edit'></i>Editar</a>");
            out.println("<a href='/WebExemplo02/alimentos/excluir?id="
                    + alimento.getId() + "'class='btn btn-outline-danger'><i class='fa fa-trash'></i>Excluir</a>");

            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("<tfoot>");
        out.println("<tr>");
        out.println("<th>Código</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Quantidade</th>");
        out.println("<th>Preço</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</tfoot>");
        out.println("</table>");

        out.println("</div>");
        out.println("</div>");

    }

}
