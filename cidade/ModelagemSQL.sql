CREATE TABLE IF NOT EXISTS CIDADE(
	ddd int NOT NULL,
	nome VARCHAR (50) NOT NULL,
	nro_habitantes float NOT NULL,
	renda_per_capita float,
	capital boolean,
	estado varchar (2),
	nome_prefeito varchar(50),
	PRIMARY KEY (ddd)
);