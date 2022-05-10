-- Crea la tablas Secciones
CREATE TABLE articulos (
  idArt int NOT NULL,
  tituloArt varchar(45) DEFAULT NULL,
  textoArt varchar(500) DEFAULT NULL,
  PRIMARY KEY (idArt)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Crea la tabla subsecciones
CREATE TABLE subsecciones (
  idSub int NOT NULL,
  tituloSub varchar(45) DEFAULT NULL,
  textoSub varchar(500) DEFAULT NULL,
  articulo int DEFAULT NULL,
  PRIMARY KEY (idSub),
  KEY articulo_idx (articulo),
  CONSTRAINT articulo FOREIGN KEY (articulo) REFERENCES articulos (idArt)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE usuarios (
  idUsu INT NOT NULL,
  nombreUsu VARCHAR(45) NULL,
  passUsu VARCHAR(45) NULL,
  PRIMARY KEY (idUsu)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  

-- Carga las tablas
insert into articulos 
values(1,'Article heading','Lorem ipsum dolor sit amet, consectetur adipisicing elit. Donec a diam lectus. Set sit amet ipsum mauris. Maecenas congue ligula as quam viverra nec consectetur ant hendrerit. Donec et mollis dolor. Praesent et diam eget libero egestas mattis sit amet vitae augue. Nam tincidunt congue enim, ut porta lorem lacinia consectetur.'); 

insert into subsecciones
values(1,'Subsection','Donzxzec ut librero sed accu vehicula ultricies a non tortor. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aenean ut gravida lorem. Ut turpis felis, pulvinar a semper sed, adipiscing id dolor. Pelientesque auctor nisi id magna consequat sagittis. ',1);

insert into subsecciones
values(2,'Another subsection','Donec viverra mi quis quam pulvinar at malesuada arcu rhoncus. Cum soclis natoque penatibus et manis dis parturient montes, nascetur ridiculus mus. In rutrum accumsan ultricies. Mauris vitae nisi at sem facilisis semper ac in est.',1);

INSERT INTO usuarios 
VALUES (1,'faguirre','password');
