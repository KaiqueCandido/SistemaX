CREATE TABLE Usuario (
	id SERIAL NOT NULL,
	email VARCHAR(60) NOT NULL UNIQUE,
	nomeDeUsuario VARCHAR(60) NOT NULL UNIQUE,
	senha VARCHAR(20)NOT NULL,		
	foto VARCHAR (255),
	tipo VARCHAR (20) NOT NULL,
	matricula VARCHAR (20) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE Feriados(
	id Serial NOT NULL,
	data DATE NOT NULL,
	feriado VARCHAR (120) NOT NULL,
	PRIMARY KEY (id)
);

insert into Usuario(email, nomeDeUsuario, senha, Matricula, tipo) values ('kaique25_ci@hotmail.com', 'root', 'xs123chg', '000000', 'ADM');