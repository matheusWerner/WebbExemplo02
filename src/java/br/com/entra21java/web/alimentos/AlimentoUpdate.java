/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.alimentos;

import br.com.entra21java.bean.AlimentoBean;
import br.com.entra21java.dao.AlimentoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet("/alimentos/update")
public class AlimentoUpdate extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, 
    HttpServletResponse resp) throws ServletException, IOException {
        AlimentoBean alimento = new AlimentoBean();
        alimento.setNome(req.getParameter("nome"));
        alimento.setDescricao(req.getParameter("descricao"));
        alimento.setId(Integer.parseInt(req.getParameter("id")));
        alimento.setQuantidade(Byte.parseByte(req.getParameter("quantidade")));
        alimento.setPreco(Double.parseDouble(req.getParameter("preco")));
        boolean alterou = new AlimentoDAO().alterar(alimento);
    }
    
    
    
}
