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

<<<<<<< HEAD
CREATE TABLE Feriado(
	idFeriado SERIAL NOT NULL,
	nomeFeriado VARCHAR(60) NOT NULL,
	dataFeriado DATE NOT NULL,
	PRIMARY KEY(idFeriado)
);
=======
CREATE TABLE Feriados(
	id Serial NOT NULL,
	data DATE NOT NULL,
	feriado VARCHAR (120) NOT NULL,
	PRIMARY KEY (id)
);

insert into Usuario(email, nomeDeUsuario, senha, Matricula, tipo) values ('kaique25_ci@hotmail.com', 'root', 'xs123chg', '000000', 'ADM');
>>>>>>> a99d44de8af715fa6dc1c3996186f20430b1595b
