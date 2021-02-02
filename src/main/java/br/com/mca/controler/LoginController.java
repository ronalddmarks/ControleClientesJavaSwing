package br.com.mca.controler;

import br.com.mca.dao.LoginDao;
import br.com.mca.model.Login;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoginController {
    
    public ArrayList<Login> buscarLoginSenha() throws SQLException, ClassNotFoundException{
        
        
        return LoginDao.buscarLogin();
        
    }

}
