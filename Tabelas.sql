CREATE TABLE Usuario (
	id SERIAL NOT NULL,
	email VARCHAR(60) NOT NULL UNIQUE,
	nomeDeUsuario VARCHAR(60) NOT NULL UNIQUE,
	senha VARCHAR(20)NOT NULL,		
	foto VARCHAR (255),
	tipo VARCHAR (20) NOT NULL,
	matricula VARCHAR (6) NOT NULL,
	status VARCHAR (20) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE Feriado(
	idFeriado SERIAL NOT NULL,
	nomeFeriado VARCHAR(60) NOT NULL,
	dataFeriado DATE NOT NULL,
	PRIMARY KEY(idFeriado)
);

insert into Usuario(email, nomeDeUsuario, senha, Matricula, tipo, status) values ('email@email.com', 'root', 'xs123chg', '000000', 'ADMINISTRADOR', 'Ativo');

