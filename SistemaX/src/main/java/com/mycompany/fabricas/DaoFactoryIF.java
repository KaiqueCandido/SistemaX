package com.mycompany.fabricas;

import Interfaces.AmizadeDaoIF;
import Interfaces.AtoresDaoIF;
import Interfaces.DiretoresDaoIF;
import Interfaces.FilmeDaoIF;
import Interfaces.FotoDaoIF;
import Interfaces.GrupoDaoIF;
import Interfaces.TopicoDaoIF;
import Interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {
    
    public AmizadeDaoIF criaAmizadeDao();
    
    public AtoresDaoIF criaAtoresDao();
    
    public DiretoresDaoIF criaDiretoresDao();
    
    public FilmeDaoIF criaFilmeDao();
    
    public GrupoDaoIF criaGrupoDao();
    
    public TopicoDaoIF criaTopicoDao();
    
    public UsuarioDaoIF criaUsuarioDao();
    
    public FotoDaoIF criaFotoDao();
}
