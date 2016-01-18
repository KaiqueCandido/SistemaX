package com.mycompany.fabricas;

import com.mycompany.dao.AmizadeDao;
import com.mycompany.dao.AtoresDao;
import com.mycompany.dao.DiretoresDao;
import com.mycompany.dao.FilmeDao;
import com.mycompany.dao.GrupoDao;
import com.mycompany.dao.TopicoDao;
import com.mycompany.dao.UsuarioDao;
import com.mycompany.dao.FotoDao;
import Interfaces.AmizadeDaoIF;
import Interfaces.AtoresDaoIF;
import Interfaces.DiretoresDaoIF;
import Interfaces.FilmeDaoIF;
import Interfaces.FotoDaoIF;
import Interfaces.GrupoDaoIF;
import Interfaces.TopicoDaoIF;
import Interfaces.UsuarioDaoIF;

public class DaoFactoryBD implements DaoFactoryIF{
    
    private DaoFactoryBD instance;
    
    public AmizadeDaoIF criaAmizadeDao() {
        return new AmizadeDao();
    }

    public AtoresDaoIF criaAtoresDao() {
        return new AtoresDao();
    }

    public DiretoresDaoIF criaDiretoresDao() {
        return new DiretoresDao();
    }
    
    public FilmeDaoIF criaFilmeDao() {
        return new FilmeDao();
    }

    public GrupoDaoIF criaGrupoDao() {
        return new GrupoDao();
    }

    public TopicoDaoIF criaTopicoDao() {
        return new TopicoDao();
    }

    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }
    
    public FotoDaoIF criaFotoDao() {
        return new FotoDao();
    }
}
